package se.kth.iv1350.salesystem.model;

public class TotalCostDiscount implements DiscountStrategy{

    @Override
    public AmountDTO calculateDiscount(SaleDTO sale, DiscountDTO discountInformation){

        //kommer ändras
        AmountDTO totalCostDiscount = new AmountDTO(0);
        return totalCostDiscount;
    }
    
}
