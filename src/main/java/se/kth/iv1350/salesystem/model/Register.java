package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents the physical register that keeps the payment for a sale and holds the current balance. 
 */
public class Register {
    private AmountDTO balance;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
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
    
    public void updateBalance(AmountDTO saleRevenue){
        this.balance = new AmountDTO(this.balance.getValue() + saleRevenue.getValue());
        notifyObservers(saleRevenue);
        
    }

    private void addRevenueObserver(RevenueObserver observer){
        revenueObservers.add(observer);
    }

    private void notifyObservers(AmountDTO saleRevenue){
        for (RevenueObserver observer : revenueObservers){
            observer.updateTotalRevenue(saleRevenue);
        }
    }
    

}
