package se.kth.iv1350.salesystem.model;

public class CustomerDiscount implements DiscountStrategy{

    @Override
    public AmountDTO calculateDiscount(SaleDTO sale, DiscountDTO discountInformation){
        
        //kommer ändras
        AmountDTO customerDiscount = new AmountDTO(0);

        return customerDiscount;
    }
    
}
