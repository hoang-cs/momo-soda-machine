package com.company.view;

import com.company.models.Menu;

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
        System.out.println("Please choose a product you want !!!\n");
        System.out.println("=============MENU==============");

        System.out.println("0. Exit now");

        for (int i = 0; i < menu.getProducts().size(); i++){
            System.out.println((i+1) + ". " + menu.getProducts().get(i));
        }

        System.out.println(" ===============================");
    }

    public void displayNotEnoughMoneyMsg(){
        System.out.println("You don't have enough money to buy this product, try again later !!!");
    }

    public void displayProductNotExistMsg(){
        System.out.println("This product doesn't exist, try again later");
    }

    public void displayProductMsg(String productInfo){
        System.out.println("Here's your product: " + productInfo);
    }

    public void displayRemainChangeMsg(long refund){
        System.out.println("Your remaining change: " + refund);
    }

    public void displayRefundMoneyMsg(long moneyReceived){
        System.out.println("Refunding your money: " + moneyReceived);
    }

    public void displayOutroMsg(){
        System.out.println("Thanks for using our service <3");
        System.out.println("Hope to see you again <3");
    }

    public void clearScreen(){
        try {
            Thread.sleep(3000);
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (Exception e){
            System.out.println("cannot clear console screen");
            e.printStackTrace();
        }
    }
}
