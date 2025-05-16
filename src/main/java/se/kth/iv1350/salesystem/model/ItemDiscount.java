package se.kth.iv1350.salesystem.model;

import java.util.List;

public class ItemDiscount implements DiscountStrategy {

    private List<DiscountDTO> itemDiscounts;
    /**
     * Creates the ItemDiscount object and sets the list of disocunts. 
     * @param customerDiscounts the list of discounts for different items from the database.
     */
    public ItemDiscount(List<DiscountDTO> itemDiscounts){
        this.itemDiscounts = itemDiscounts;
    }
    
    /**
     * Finds applicable discount for the items in the cart, if multiple items have a discount they are 
     * combined. 
     * @param discountEligibility Information to determine if the sale is eligible for discounts. 
     * @return sumToReduce The total sum to reduce from the total sale cost. 
     */
    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility){
        
        double sumToReduce = 0;

        for(DiscountDTO discount : itemDiscounts)
        {
            for(ItemDTO item : discountEligibility.getCart())
            {
                if (discount.getItemID() == item.getItemID())
                {
                    sumToReduce += discount.getDiscountAmount().getValue(); 
                }
            }
        }
        
        AmountDTO itemDiscount = new AmountDTO(sumToReduce);
        return itemDiscount;
    }
    
}
