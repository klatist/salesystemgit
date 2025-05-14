package se.kth.iv1350.salesystem.integration;

import se.kth.iv1350.salesystem.model.DiscountDTO;
import java.util.List;
import java.util.ArrayList;
/**
 * This class represent a discount database.
 * It contains available discounts and handles search for applicable discounts.
 */
public class DiscountDatabase {

    private  List<DiscountDTO> customerDiscount;
    private List<DiscountDTO> itemDiscount;
    private List<DiscountDTO> totalCostDiscount;

    public List<DiscountDTO> getCustomerDisount(){
        return customerDiscount;
    }
    
    public List<DiscountDTO> getItemDisount(){
        return itemDiscount;
    }

    public List<DiscountDTO> gettotalCostDisount(){
        return totalCostDiscount;
    }

    public DiscountDatabase(){
        this.customerDiscount = new ArrayList<>();
        this.itemDiscount = new ArrayList<>();
        this.totalCostDiscount = new ArrayList<>();
        addDiscount();
    }

    private void addDiscount(){

        DiscountDTO studentDiscount = new DiscountDTO(111111,0.05);
        DiscountDTO purchaseOver100 = new DiscountDTO();
        DiscountDTO kalaspuffDiscount = new DiscountDTO();

        customerDiscount.add(studentDiscount);
        itemDiscount.add(kalaspuffDiscount);
        totalCostDiscount.add(purchaseOver100);

    }


}

