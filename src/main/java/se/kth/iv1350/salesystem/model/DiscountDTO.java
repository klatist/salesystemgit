package se.kth.iv1350.salesystem.model;
/**
 * Store th requirement to be eligible for the discount and the discount in % or amount. 
 */
public class DiscountDTO {
    private AmountDTO discountAmount;
    private double discountPercentage;
    private AmountDTO minPurchaseAmountRequired;
    private int itemID;
    private int customerID;

    /**
     * Constructor for discounts for specific items.
     * @param itemID The item that have a dsicount.
     * @param  disocuntAmount The amount to reduce.
     */
    public DiscountDTO(int itemID, AmountDTO discountAmount){
        this.itemID = itemID;
        this.discountAmount = discountAmount;
            
    }
    /**
     * Constructor for discounts for specific customerIDs.
     * @param customerID The customer id that have a discount.
     * @param discountPercentage The percentage of the total sale cost to be reduced. 
     */
    public DiscountDTO(int customerID, double discountPercentage){
        this.customerID = customerID;
        this.discountPercentage = discountPercentage;
    }
    /**
     * Constructor for discounts for that apply for certain total costs.
     * @param minPurchaseAmountRequired The minimum sum to be eligible for the discount.
     * @param discountPercentage The percentage of the total sale cost to be reduced. 
     */
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
