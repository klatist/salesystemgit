package se.kth.iv1350.salesystem.model;

import java.util.List;

public class ItemDiscount implements DiscountStrategy {

    private List<DiscountDTO> itemDiscounts;

    public ItemDiscount(List<DiscountDTO> itemDiscounts){
        this.itemDiscounts = itemDiscounts;
    }
    
    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility){
        
        double sumToReduce = 0;

        for(DiscountDTO discount : itemDiscounts)
        {
            for(ItemDTO item : discountEligibility.getCart())
            {
                if (discount.getItemID() == item.getItemID())
                {
                    sumToReduce += discountEligibility.getTotalPrice(); 
                }
            }
        }
        
        AmountDTO itemDiscount = new AmountDTO(sumToReduce);
        return itemDiscount;
    }
    
}
