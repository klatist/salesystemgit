package se.kth.iv1350.salesystem.model;
/**
 * Represent the physical register that keeps the payment for a sale and holds the current balance. 
 */
public class Register {
    private double balance;
    /**
     * Creates a new register and set initial balance to 0.
     */
    public Register(){
        this.balance = 0.0; 
    }
    /**
     * Updates the amount in the register after a sale.
     * @param finalSaleInformation containt the total price of the sale. 
     */
    
    public void updateBalance(SaleDTO finalSaleInformation){
        this.balance += finalSaleInformation.getTotalSalePriceValue();
    }


}
