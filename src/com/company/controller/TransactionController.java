package com.company.controller;

import com.company.models.Menu;
import com.company.models.Transaction;
import com.company.models.ValidMoney;
import com.company.view.MachineView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TransactionController {

    private final PromotionController promotionController;
    private final List<Long> moneyAccept;
    private final MachineView view;
    private final Menu menu;

    private final Scanner input = new Scanner(System.in);

    public TransactionController() {
        this.promotionController = new PromotionController();
        this.moneyAccept = ValidMoney.getAcceptInstance().getMoneyAccept();
        this.menu = Menu.getMenuInstance();
        this.view = new MachineView();
    }


    // create an infinite loop to handle all requests from customer
    public void startMachine(){
        while (true){
            Transaction transaction = new Transaction();
            boolean isValidMoney = receiveMoney(transaction);

            if (!isValidMoney)  continue;

            selectProduct(transaction);
        }

    }

    // return true if received 10.000, 20.000, 50.000, 100.000, 200.000 VND
    // else, return false
    public boolean receiveMoney(Transaction transaction){
        view.displayIntroMsg();

        String moneyReceive;
        moneyReceive = input.nextLine();

        try {
            transaction.setMoneyReceived(Long.parseLong(moneyReceive));
        } catch (Exception e){
            // customer input something not a number
            view.displayNotMoneyMsg();
            view.clearScreen();
            return false;
        }

        // received money but not 10.000, 20.000, 50.000, 100.000 or 200.000 VND
        if (!this.moneyAccept.contains(transaction.getMoneyReceived())){
            view.displayWrongMoneyTypeMsg();
            cancel(transaction);
            view.clearScreen();
            return false;
        }
        return true;
    }

    // return true if the customer select a valid product
    // return false if product selected is invalid or customer
    // wants to cancel the request
    public void selectProduct(Transaction transaction){
        view.displayMenu();

        int choice = input.nextInt();
        input.nextLine();

        // choice == 0 => cancel the request
        if (choice == 0) {
            cancel(transaction);
            view.clearScreen();
        }
        // a valid choice
        else if (choice-1 >= 0 && choice-1 < menu.getProducts().size()){
            transaction.setProduct(menu.getProducts().get(choice-1));

            // check if the chosen product has price exceed the money received
            if (transaction.getProduct().getPrice() > transaction.getMoneyReceived()){
                view.displayNotEnoughMoneyMsg();
                cancel(transaction);
            }
            else {
                releaseProduct(transaction);
                remainingChange(transaction);
                view.displayOutroMsg();
            }
            view.clearScreen();
        }
        // an invalid choice
        else {
            view.displayProductNotExistMsg();
            cancel(transaction);
            view.clearScreen();
        }
    }

    // dropdown the chosen product and display its info
    public void releaseProduct(Transaction transaction){
        if (transaction != null) {
            String productInfo = transaction.getProduct().toString();
            transaction.setDatetime(LocalDate.now());
            view.displayProductMsg(productInfo);
            promotionController.addTransaction(transaction);
        }
    }

    // return the refund change and display message
    public void remainingChange(Transaction transaction){
        if (transaction.getProduct() != null){
            long remain = transaction.getMoneyReceived() - transaction.getProduct().getPrice();
            view.displayRemainChangeMsg(remain);
        }
    }

    // called when customer want to cancel the transaction
    // return the money received
    public void cancel(Transaction transaction){
        long refund = transaction.getMoneyReceived();
        view.displayRefundMoneyMsg(refund);
    }

}
