package se.kth.iv1350.salesystem.model;
/**
 * Represent the physical register that keeps the payment for a sale and holds the current balance. 
 */
public class Register {
    private AmountDTO balance;
    /**
     * Creates a new register and set initial balance to 0.
     */
    public Register(double money){
        this.balance = new AmountDTO(money); 
    }
    /**
     * Updates the amount in the register after a sale.
     * @param finalSaleInformation containt the total price of the sale. 
     */

    public AmountDTO getBalance(){
        return this.balance;
    }
    
    public void updateBalance(AmountDTO runningTotal){
        this.balance = new AmountDTO(this.balance.getValue() + runningTotal.getValue());
        
    }


}
