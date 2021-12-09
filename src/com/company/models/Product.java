package com.company.models;

import java.util.UUID;

public class Product {
    private final UUID id;
    private String name;
    private long price;

    public Product() {
        id = UUID.randomUUID();
    }

    public Product(String name, long price) {
        this.id = UUID.randomUUID();
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
