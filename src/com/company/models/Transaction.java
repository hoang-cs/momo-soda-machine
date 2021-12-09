package com.company.models;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private LocalDate datetime;
    private long moneyReceived;
    private Product product;

    public Transaction() {
        this.id = UUID.randomUUID();
    }

    public Transaction(LocalDate datetime, long moneyReceived, Product product) {
        this.id = UUID.randomUUID();
        this.datetime = datetime;
        this.moneyReceived = moneyReceived;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public long getMoneyReceived() {
        return moneyReceived;
    }

    public void setMoneyReceived(long moneyReceived) {
        this.moneyReceived = moneyReceived;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
