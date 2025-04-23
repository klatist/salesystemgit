package se.kth.iv1350.salesystem.model;

import java.util.Currency; //?

public class Amount {
    private Currency currency;
    private double amount;

    public Amount(){
        this.currency = "SEK";
        this.amount = 0;
    }

    public Amount(String currency, double amount){
        this.currency = currency;
        this.amount = amount;

    }

    //bara ha flexibel amount, med SEK
    public Amount(double amount){

    }

    public String getCurrency(){
        return currency;
    }

    public double getAmount(){
        return amount;
    }

    public void add (Amount toBeAdded){
        this.amount += toBeAdded.amount;
    }

    public Amount multiply(double toBeMultiplied){
        return new Amount(this.amount*toBeMultiplied);
    }
    

}
