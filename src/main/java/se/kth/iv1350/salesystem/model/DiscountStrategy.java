package se.kth.iv1350.salesystem.model;

/**
 * This interface represents a strategy for applying discounts.
 * Implementations define how a discount should be calculated based on the specifics of the
 * discount type.
 */
public interface DiscountStrategy {
    /**
     * Called by the strategies to find applicable discounts and calculate the sum to be reduced.
     @param discountEligibility Information to determine if the sale is eligible for discounts. 
     */
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility);
    
}
