package se.kth.iv1350.salesystem.model;

import java.util.List;
/**
 * This class represents the discount strategy specific for discounts that is based on the total
 * cost of the sale.
 */
public class TotalCostDiscount implements DiscountStrategy{
    private List<DiscountDTO> totalCostDiscounts;

    /**
     * Creates the <code>TotalCostDiscount</code> object and sets the list of discounts. 
     * @param customerDiscounts the list of discounts applicable for the total sum of the <code>sale</code>. 
     * The discounts are stored in order from highest to lowest <code>minPurchaseAmount</code>. 
     */
    public TotalCostDiscount(List<DiscountDTO> totalCostDiscounts){
        this.totalCostDiscounts = totalCostDiscounts;
    }

    /**
    * Determines the applicable discount based on the total purchase amount.
    * Only one discount can be applied, and it selects the highest discount that the purchase qualifies for.
    * @param discountEligibility Information to determine if the sale is eligible for discounts. 
    * @return The dicounted amount to reduce from the total sale price.
    */
   @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility){
        
        
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
