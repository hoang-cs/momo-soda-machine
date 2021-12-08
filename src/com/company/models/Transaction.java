package com.company.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private LocalDateTime datetime;
    private long moneyReceived;
    private Product product;

    public Transaction() {
        this.id = UUID.randomUUID();
    }

    public Transaction(LocalDateTime datetime, long moneyReceived, Product product) {
        this.id = UUID.randomUUID();
        this.datetime = datetime;
        this.moneyReceived = moneyReceived;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
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
