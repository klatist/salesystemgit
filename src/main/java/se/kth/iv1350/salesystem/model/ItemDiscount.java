package se.kth.iv1350.salesystem.model;

public class ItemDiscount implements DiscountStrategy {

    @Override
    public AmountDTO calculateDiscount(SaleDTO sale, DiscountDTO discountInformation){
        //kommer ändras 
        AmountDTO itemDiscount = new AmountDTO(0);

        return itemDiscount;
    }
    
}
