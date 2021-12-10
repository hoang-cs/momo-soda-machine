package com.company.models;

import java.time.LocalDate;

public class Transaction {
    private long moneyReceived;
    private LocalDate datetime;
    private Product product;

    public Transaction() {

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
