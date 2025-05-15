package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;

public class DiscountComposite implements DiscountStrategy{
    
    private List<DiscountStrategy> discountStrategies = new ArrayList<>();

    public void addDiscountStrategy(DiscountStrategy discountStrategy){
        discountStrategies.add(discountStrategy);
    }

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
