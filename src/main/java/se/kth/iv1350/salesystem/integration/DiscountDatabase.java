package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.DiscountDTO;
/**
 * This class represent a discount database.
 * The discounts are stored in a DiscountDTO which holds the requirement to get the discount and the discount (sum or %)
 * and are divideed in the groups. 
 */
public class DiscountDatabase {

    private  List<DiscountDTO> customerDiscounts;
    private List<DiscountDTO> itemDiscounts;
    private List<DiscountDTO> totalCostDiscounts;

    public List<DiscountDTO> getCustomerDiscounts(){
        return customerDiscounts;
    }
    
    public List<DiscountDTO> getItemDiscounts(){
        return itemDiscounts;
    }

    public List<DiscountDTO> getTotalCostDiscounts(){
        return totalCostDiscounts;
    }

    /**
     * The constructor creates the three lists and calls the addDiscount.
     */
    public DiscountDatabase(){
        this.customerDiscounts = new ArrayList<>();
        this.itemDiscounts = new ArrayList<>();
        this.totalCostDiscounts = new ArrayList<>();
        addDiscount();
    }

    /**
     * Adds hardcoded dicounts to the database lists. 
     */
    private void addDiscount(){

        DiscountDTO studentDiscount = new DiscountDTO(0304050607,0.1);
        DiscountDTO purchaseOver100 = new DiscountDTO(new AmountDTO(100), 0.05);
        DiscountDTO kalaspuffDiscount = new DiscountDTO(654321, new AmountDTO(7));

        customerDiscounts.add(studentDiscount);
        itemDiscounts.add(kalaspuffDiscount);
        totalCostDiscounts.add(purchaseOver100);

    }

}

