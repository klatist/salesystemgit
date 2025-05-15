package se.kth.iv1350.salesystem.model;

import java.util.List;

public class CustomerDiscount implements DiscountStrategy{

    private List<DiscountDTO> customerDiscounts;

    public CustomerDiscount(List<DiscountDTO> customerDiscounts){
        this.customerDiscounts = customerDiscounts;
    }

    @Override
    public AmountDTO calculateDiscount(DiscountEligibilityDTO discountEligibility){
        double sumToReduce = 0;

        for(DiscountDTO discount : customerDiscounts)
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
