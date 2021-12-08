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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.getPrice() + " VND";
    }
}
