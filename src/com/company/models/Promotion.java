package com.company.models;

public class Promotion {

    public static final int CONSECUTIVE = 3;

    private double winRate;
    private long limitBudget;
    private static Promotion promotionInstance;


    public Promotion(){
        newDay();
    }

    public static Promotion getPromotionInstance(){
        if (promotionInstance == null)
            promotionInstance = new Promotion();

        return promotionInstance;
    }

    public double getWinRate(){
        return this.winRate;
    }
    public long getLimitBudget(){
        return this.limitBudget;
    }

    // return true if the budget is enough to give away a product
    // otherwise, return false
    public void decreaseBudget(long dec){
        this.limitBudget -= dec;
    }

    // if budget cannot reach to limit, win rate will be 0.5
    // otherwise, win rate will be 0.1
    public void newDay(){
        if (limitBudget != 0)
            this.winRate = 0.5;
        else
            this.winRate = 0.1;

        this.limitBudget = 50_000L;
    }

}
