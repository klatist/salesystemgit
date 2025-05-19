package se.kth.iv1350.salesystem.model;

import java.util.List;
/**
 * The class that holds information to determine if the sale is eligible for discounts
 */
public class DiscountEligibilityDTO {
    private SaleDTO sale;
    private int customerID;

    /**
     * Creates the DTO
     * @param sale Information about the sale, total cost and the items in the sale are relevant for dicounts
     * @param customerID Unique ID for a customer
     */
    public DiscountEligibilityDTO(SaleDTO sale, int customerID) {
        this.sale = sale;
        this.customerID = customerID;
    }

    public List<ItemDTO> getCart(){
        return sale.getCurrentCart();
    }

    public double getTotalPrice(){
        return sale.getRunningTotalValue();
    }

    public int getCustomerID(){
        return customerID;
    }

    
    
}
