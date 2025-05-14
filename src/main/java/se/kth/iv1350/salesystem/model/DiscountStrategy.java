package se.kth.iv1350.salesystem.model;

public interface DiscountStrategy {

    public AmountDTO calculateDiscount(SaleDTO sale, DiscountDTO discountInformation);
    
}
