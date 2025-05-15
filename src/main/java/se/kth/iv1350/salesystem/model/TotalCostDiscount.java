package se.kth.iv1350.salesystem.model;

import java.util.List;

public class TotalCostDiscount implements DiscountStrategy{

    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility, List<DiscountDTO> totalCostDiscounts){
        
        
        for(DiscountDTO discount : totalCostDiscounts)
        {
            if (discountEligibility.getTotalPrice() > discount.getMinPurchaseAmountRequired().getValue())
            {
                double sumToReduce = discountEligibility.getTotalPrice() * discount.getDiscountPercentage();
                return new AmountDTO(sumToReduce);
            }
        }

        return new AmountDTO(0);        
    }
    
}
