package se.kth.iv1350.salesystem.model;

import java.util.List;
/**
 * This class finds the applicablee discount based on the customerID
 */

public class CustomerDiscount implements DiscountStrategy{

    private List<DiscountDTO> customerDiscounts;

    /**
     * Creates the customerDiscount object and sets the list of discounts. 
     * @param customerDiscounts the list of discounts for a customerID from the database.
     */
    public CustomerDiscount(List<DiscountDTO> customerDiscounts){
        this.customerDiscounts = customerDiscounts;
    }
    /**
     * Finds all applicable discounts for the customerID and summarize them into an amount.
     * @param discountEligibility Information to determine if the sale is eligible for discounts,contain customerID
     * @return customerDiscount The total discount sum to be reduced from the sale cost. 
     */
    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility){
        double sumToReduce = 0;

        for(DiscountDTO discount : customerDiscounts)
        {  
            if(discountEligibility.getCustomerID() == discount.getCustomerID())
            {
                sumToReduce += discountEligibility.getTotalPrice() * discount.getDiscountPercentage();
            }
        }

        AmountDTO customerDiscount = new AmountDTO(sumToReduce);

        return customerDiscount;
    }
    
}
