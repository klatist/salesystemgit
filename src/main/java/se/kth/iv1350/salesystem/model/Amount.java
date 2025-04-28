package se.kth.iv1350.salesystem.model;

import java.util.Currency; 
/**
 * This class represents an amount of money of a specified currency.
 */
public class Amount {
    private Currency currency;
    private double value;

    /**
     * Constructor that creates an <code>Amount</code> object with default values for <code>currency</code>
     * and <code>amount</code> to SEK and 0 respectively.
     */
    public Amount(){
        this.currency = Currency.getInstance("SEK");
        this.value = 0;
    }

    /**
     * Constructor that creates an <code>Amount</code> object without any default values.
     * @param currency Represents the <code>currency</code> that should be used.
     * @param value Represents the <code>amount</code> of money.
     */
    public Amount(Currency currency, double value){
        this.currency = currency;
        this.value = value;

    }

    /**
     * Constructor that creates an <code>Amount</code> object that has a default value for 
     * <code>currency> set to SEK but no default value for the <code>amount</code>.
     * @param amount Represents the <code>amount</code> of money.
     */
    public Amount(double value){
        this.currency = Currency.getInstance("SEK");
        this.value = value;
    }

    public Currency getCurrency(){
        return currency;
    }

    public double getValue(){
        return value;
    }

    /**
     * Adds another <code>Amount</code> to this amount.
     * If the parameter is <code>null</code>, no change occurs.
     * @param toBeAdded Represents the amount that is to be added to the current amount.
     */
    public void addAmount (Amount toBeAdded){
        if (toBeAdded != null){
        this.value += toBeAdded.value;
        }
    }

    /**
     * Multiplies the current <code>amount</code> with a number and creates a ne
     * @param toBeMultiplied Represents the factor to be multiplied with.
     * @return returns a new <code>amount</code> that has been calculated.
     */
    public Amount multiply(double toBeMultiplied){
        return new Amount(this.value*toBeMultiplied);
    }
    

}
