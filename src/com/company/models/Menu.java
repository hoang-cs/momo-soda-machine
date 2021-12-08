package com.company.models;

import java.util.ArrayList;
import java.util.List;

// Create a menu class to manage the products list
// Using Singleton DP
public class Menu {
    private final List<Product> products;

    private static Menu instance;

    private Menu() {
        products = new ArrayList<>();

        products.add(new Product("Coke", 10000));
        products.add(new Product("Pepsi", 10000));
        products.add(new Product("Soda", 20000));
    }

    public static Menu getMenuInstance(){
        if (instance == null){
            instance = new Menu();
        }

        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }
}
