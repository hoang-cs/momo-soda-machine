package com.company.models;

public class Product {
    private String name;
    private long price;

    public Product() {
    }

    public Product(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return this.name + " - " + this.getPrice() + " VND";
    }
}
