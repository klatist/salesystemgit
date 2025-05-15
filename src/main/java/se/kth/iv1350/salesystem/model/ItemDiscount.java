package se.kth.iv1350.salesystem.model;

import java.util.List;

public class ItemDiscount implements DiscountStrategy {

    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO disocuntEligibility, List<DiscountDTO> itemDiscounts){
        
        double sumToReduce = 0;

        for(DiscountDTO discount : itemDiscounts)
        {
            for(ItemDTO item : disocuntEligibility.getCart())
            {
                if (discount.getItemID() == item.getItemID())
                {
                    sumToReduce += disocuntEligibility.getTotalPrice(); 
                }
            }
        }
        
        AmountDTO itemDiscount = new AmountDTO(sumToReduce);
        return itemDiscount;
    }
    
}
