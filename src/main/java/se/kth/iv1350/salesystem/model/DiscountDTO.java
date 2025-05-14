package se.kth.iv1350.salesystem.model;

public class DiscountDTO {
    private AmountDTO discountAmount;
    private double discountPercentage;
    private AmountDTO minPurchaseAmountRequired;
    private int itemID;
    private int customerID;

    public DiscountDTO(int itemID, AmountDTO discountAmount){
        this.itemID = itemID;
        this.discountAmount = discountAmount;
            
    }
    
    public DiscountDTO(int customerID, double di){
        this.itemID = currentItemId;
        customerID
    }

    public DiscountDTO(int currentItemId){
        this.itemID = currentItemId;
        customerID
    }
}
