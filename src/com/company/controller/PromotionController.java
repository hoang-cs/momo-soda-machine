package com.company.controller;

import com.company.models.Menu;
import com.company.models.Product;
import com.company.models.Promotion;
import com.company.models.Transaction;
import com.company.view.MachineView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PromotionController {
    private final List<Transaction> transactions;
    private final Promotion promoInfo;
    private final MachineView view;
    private final Random random;
    private final Menu menu;
    private LocalDate date;

    public PromotionController(){
        this.promoInfo = Promotion.getPromotionInstance();
        this.transactions = new ArrayList<>();
        this.menu = Menu.getMenuInstance();
        this.view = new MachineView();
        this.date = LocalDate.now();
        this.random = new Random();
    }

    public void addTransaction(Transaction transaction){

        // check if the new transaction's date is different from previous transaction's
        // => new day
        if (transaction.getDatetime().isAfter(date)) {
            this.promoInfo.newDay();
            this.date = LocalDate.now();
        }

        transactions.add(transaction);

        // if there are 3 consecutive purchases of the same product
        // and the random number is a lucky number
        if (isConsecutive() && isYourLuckyDay()){
            pickAFreeProduct();
        }
    }

    public void pickAFreeProduct(){
        Scanner input = new Scanner(System.in);
        int choice = -1;
        List<Product> luckyProducts = createLuckyList();
        this.view.displayLuckyMsg(luckyProducts);

        do{
            try{
                choice = Integer.parseInt(input.nextLine());
                Product luckyProduct = luckyProducts.get(choice-1);
                view.displayFreeProductMsg(luckyProduct.getName());
                promoInfo.decreaseBudget(luckyProduct.getPrice());
            } catch (NumberFormatException numE){
                view.displayWrongFormatNumber();
            } catch (IndexOutOfBoundsException indexE){
                view.displayProductNotExistMsg();
                choice = -1;
            }
        }while (choice == -1);
    }

    public boolean isConsecutive(){
        // not enough product in stack
        if (this.transactions.size() < Promotion.CONSECUTIVE)
            return false;

        if (this.transactions.size() > Promotion.CONSECUTIVE)
            transactions.remove(0);

        // loop used for checking consecutive products in array list
        for (int i = 0; i < transactions.size()-1; i++){
            Transaction cur = transactions.get(i);
            String curProductName = cur.getProduct().getName();

            Transaction next = transactions.get(i+1);
            String nextProductName = next.getProduct().getName();

            if (!curProductName.equals(nextProductName))
                return false;
        }
        return true;
    }

    // create a list included products has price <= limit budget
    public List<Product> createLuckyList(){
        List<Product> luckyProducts = new ArrayList<>();
        for(Product product : menu.getProducts()){
            if (product.getPrice() < promoInfo.getLimitBudget())
                luckyProducts.add(product);
        }

        return luckyProducts;
    }

    // return true if you have lucky number and budget haven't reached limit
    // otherwise, return false
    public boolean isYourLuckyDay(){
        int num = random.nextInt(100);

        return num / 100.0 < promoInfo.getWinRate() && promoInfo.getLimitBudget() != 0;
    }

}
