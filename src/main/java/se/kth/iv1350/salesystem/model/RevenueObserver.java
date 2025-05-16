package se.kth.iv1350.salesystem.model;

/**
 * This interface represents an observer that is notified when the total revenue is updated.
 * Implementing classes define how to react when a new <code>sale</code> has contributed
 * to the total revenue.
 */
public interface RevenueObserver {

    /**
     * Called when a new <code>sale</code> has been completed and its revenue should be added to the total.
     * 
     * @param saleRevenue represents the revenue from the most recent <code>sale</code>.
     */
    public void updateTotalRevenue(AmountDTO saleRevenue);

    
}
