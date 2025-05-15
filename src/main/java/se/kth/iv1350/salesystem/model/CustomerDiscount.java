package se.kth.iv1350.salesystem.model;

import java.util.List;

public class CustomerDiscount implements DiscountStrategy{

    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility, List<DiscountDTO> costumerDiscounts){
        double sumToReduce = 0;

        for(DiscountDTO discount : costumerDiscounts)
        {  
            if(discountEligibility.getCustomerID() == discount.getCustomerID())
            {
                sumToReduce += discountEligibility.getTotalPrice()*discount.getDiscountPercentage();
            }
        }

        AmountDTO customerDiscount = new AmountDTO(sumToReduce);

        return customerDiscount;
    }
    
}
