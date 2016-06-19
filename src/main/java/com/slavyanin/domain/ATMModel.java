package com.slavyanin.domain;

import java.util.ArrayList;

public class ATMModel {

    private ArrayList<Integer> amount;

    private ArrayList<Integer> banknotes;

    public ATMModel(ArrayList<Integer> amount, ArrayList<Integer> banknotes) {
        this.amount = amount;
        this.banknotes = banknotes;
    }

    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public void setAmount(ArrayList<Integer> amount) {
        this.amount = amount;
    }

    public ArrayList<Integer> getBanknotes() {
        return banknotes;
    }

    public void setBanknotes(ArrayList<Integer> banknotes) {
        this.banknotes = banknotes;
    }

    public void fillAllBanknotes() {
        this.banknotes.clear();
        this.banknotes.add(5);
        this.banknotes.add(10);
        this.banknotes.add(20);
        this.banknotes.add(50);
        this.banknotes.add(100);
        this.banknotes.add(200);
        this.banknotes.add(500);
    }

    public void fillOneBanknotes(int nominals, int amount){
        this.banknotes.add(nominals);
        this.amount.add(amount);
    }

    public void fillAmount() {
        this.amount.clear();
        for (int i = 0; i < 7; i++) {
            this.amount.add(50);
        }
    }
}
