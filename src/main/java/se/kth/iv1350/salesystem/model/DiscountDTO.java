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
    
    public DiscountDTO(int customerID, double discountPercentage){
        this.customerID = customerID;
        this.discountPercentage = discountPercentage;
    }

    public DiscountDTO(AmountDTO minPurchaseAmountRequired, double discountPercentage){
        this.minPurchaseAmountRequired = minPurchaseAmountRequired;
        this.discountPercentage = discountPercentage;
    }

    public AmountDTO getDiscountAmount(){
        return discountAmount;
    }

    public double getDiscountPercentage(){
        return discountPercentage;
    }

    public AmountDTO getMinPurchaseAmountRequired(){
        return minPurchaseAmountRequired;
    }

    public int getItemID(){
        return itemID;
    }

    public int getCustomerID(){
        return customerID;
    }
}
