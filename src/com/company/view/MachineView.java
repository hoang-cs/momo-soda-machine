package com.company.view;

import com.company.models.Menu;
import com.company.models.Product;

import java.util.List;

// Inside this class are methods used for print message on the console
public class MachineView {

    public void displayIntroMsg(){
        System.out.println("Hello, I'm Coin-Operated Soda Machine");
        System.out.println("Input some money to continue !!!");
    }

    public void displayNotMoneyMsg(){
        System.out.println("You didn't input money, please try again !!!");
    }

    public void displayWrongMoneyTypeMsg(){
        System.out.println("We don't use this type of money, please try again !!!");
    }

    public void displayMenu(){
        Menu menu = Menu.getMenuInstance();
        System.out.println("\nCHOOSE A PRODUCT YOU WANT !!!\n");
        System.out.println("=============MENU==============");

        System.out.println("0. Exit now");

        for (int i = 0; i < menu.getProducts().size(); i++){
            System.out.println((i+1) + ". " + menu.getProducts().get(i));
        }

        System.out.println("===============================");
    }

    public void displayNotEnoughMoneyMsg(){
        System.out.println("You don't have enough money to buy this product, try again later !!!");
    }

    public void displayWrongFormatNumber(){
        System.out.println("You have to input a number to continue");
    }

    public void displayProductNotExistMsg(){
        System.out.println("This product doesn't exist, try again later");
    }

    public void displayProductMsg(String productInfo){
        System.out.println("Here's your product: " + productInfo);
    }

    public void displayFreeProductMsg(String productInfo){
        System.out.println("\nHere's your product: " + productInfo);
        System.out.println("Buy more to get luckier <3");
    }

    public void displayRemainChangeMsg(long refund){
        System.out.println("Your remaining change: " + refund + " VND");
    }

    public void displayRefundMoneyMsg(long moneyReceived){
        System.out.println("Refunding your money: " + moneyReceived);
    }

    public void displayOutroMsg(){
        System.out.println("\nThanks for using our service <3");
        System.out.println("Hope to see you again <3");
    }

    public void displayLuckyMsg(List<Product> luckyProducts){
        System.out.println("\nToday is your lucky day");
        System.out.println("Choose a product for free !!!");
        System.out.println("==============================");
        for (int i = 0; i < luckyProducts.size(); i++){
            System.out.println((i+1) + ". " + luckyProducts.get(i).getName());
        }
    }

    public void clearScreen(){
            countDown();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
    }

    public void countDown(){
        int second = 3;
        while(second != 0){
            System.out.println("Continue in " + second + " second(s)");
            second--;
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
