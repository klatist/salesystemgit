package se.kth.iv1350.salesystem.model;

public class Amount {
    private String currency;
    private double amount;

    public Amount(){
        this.currency = "SEK";
        this.amount = 0;
    }

    public Amount(String currency, double amount){
        this.currency = currency;
        this.amount = amount;

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
    

}
