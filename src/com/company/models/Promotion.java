package com.company.models;

// A class used for storing all information about promotion
// using Singleton DP
public class Promotion {

    public static final int CONSECUTIVE = 3;

    private double winRate;
    private long limitBudget;
    private static Promotion promotionInstance;


    private Promotion(){
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
