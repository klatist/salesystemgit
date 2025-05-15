package se.kth.iv1350.salesystem.model;

import java.util.List;

public interface DiscountStrategy {

    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility);
    
}
