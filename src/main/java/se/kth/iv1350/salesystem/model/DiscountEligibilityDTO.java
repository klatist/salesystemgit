package se.kth.iv1350.salesystem.model;

import java.util.List;

public class DiscountEligibilityDTO {
    private SaleDTO sale;
    private int customerID;

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
