package com.company;

import com.company.controller.TransactionController;

public class Main {

    public static void main(String[] args) {
        TransactionController machine = new TransactionController();
        machine.startMachine();
    }
}
