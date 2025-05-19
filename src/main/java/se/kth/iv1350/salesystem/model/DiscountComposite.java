package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Composite implementation of the DiscountStrategy interface. Handle all the discount strategies 
 * and combine the calculations to return the total discount of the sale. 
 */
public class DiscountComposite implements DiscountStrategy{
    
    private List<DiscountStrategy> discountStrategies = new ArrayList<>();

    /**
    * Adds a new discount strategy to the composite.
    * @param discountStrategy A strategy to calculate discounts.
    */
    public void addDiscountStrategy(DiscountStrategy discountStrategy){
        discountStrategies.add(discountStrategy);
    }

    /**
     * Run the calculate discount method for all the strategies and calculate the total discount to reduce. 
     * @param discountEligibility Information to determine if the sale is eligible for discounts. 
     * @return totalDiscount The total sum to be reduced. 
     */
    @Override 
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility)
    {
        double totalDiscountValue = 0;

        for(DiscountStrategy strategy : discountStrategies)
        {
            AmountDTO discount = strategy.calculateDiscount(discountEligibility);
            totalDiscountValue += discount.getValue();
        }

        AmountDTO totalDiscount = new AmountDTO(totalDiscountValue);
        return totalDiscount;
    }
}
