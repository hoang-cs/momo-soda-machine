package com.company.models;

import java.util.ArrayList;
import java.util.List;

// An class used for storing accepted currencies
// Using Singleton DP
public class ValidMoney {

    private final List<Long> moneyAccept;

    private static ValidMoney validMoney;

    private ValidMoney(){
        moneyAccept = new ArrayList<>();

        moneyAccept.add(10_000L);
        moneyAccept.add(20_000L);
        moneyAccept.add(50_000L);
        moneyAccept.add(100_000L);
        moneyAccept.add(200_000L);
    }

    public static ValidMoney getAcceptInstance(){
        if (validMoney == null){
            validMoney = new ValidMoney();
        }

        return validMoney;
    }

    public List<Long> getMoneyAccept() {
        return moneyAccept;
    }
}
