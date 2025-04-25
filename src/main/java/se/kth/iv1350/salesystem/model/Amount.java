package se.kth.iv1350.salesystem.model;

import java.util.Currency; 

public class Amount {
    private Currency currency;
    private double amount;

    /**
     * Constructor that creates an <code>Amount</code> object with default values for <code>currency</code>
     * and <code>amount</code> to SEK and 0 respectively.
     */
    public Amount(){
        this.currency = Currency.getInstance("SEK");
        this.amount = 0;
    }

    /**
     * Constructor that creates an <code>Amount</code> object without any default values.
     * @param currency Represents the <code>currency</code> that should be used.
     * @param amount Represents the <code>amount</code> of money.
     */
    public Amount(Currency currency, double amount){
        this.currency = currency;
        this.amount = amount;

    }

    /**
     * Constructor that creates an <code>Amount</code> object that has a default value for 
     * <code>currency> set to SEK but no default value for the <code>amount</code>.
     * @param amount Represents the <code>amount</code> of money.
     */
    public Amount(double amount){
        this.currency = Currency.getInstance("SEK");
        this.amount = amount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public double getAmount(){
        return amount;
    }

    /**
     * Adds an another amount to current amount.
     * @param toBeAdded Represents the amount that is to be added to the current amount.
     */
    public void add (Amount toBeAdded){
        if (toBeAdded != null){
        this.amount += toBeAdded.amount;
        }
    }

    /**
     * Multiplies the current <code>amount</code> with a number.
     * @param toBeMultiplied Represents the factor to be multiplied with.
     * @return returns the new <code>amount</code> that has been calculated.
     */
    public Amount multiply(double toBeMultiplied){
        return new Amount(this.amount*toBeMultiplied);
    }
    

}
