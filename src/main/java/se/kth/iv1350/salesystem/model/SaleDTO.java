package se.kth.iv1350.salesystem.model;


import java.util.List;
import java.util.ArrayList;

public class SaleDTO {
    private Amount runningTotal;
    private double runningTotalVAT;
    private List<ItemDTO> currentCart;

    public SaleDTO(Sale sale){
        this.runningTotal = sale.getTotalPrice();
        this.runningTotalVAT = sale.getTotalVAT();
        this.currentCart = sale.getCart().toItemDTOCart();

    }

    public Amount getRunningTotal(){
        return runningTotal;
    }

    public double getRunningTotalValue(){
        return runningTotal.getValue();
    }
    
    public double getRunningTotalVAT(){
        return runningTotalVAT;
    }

    public List<ItemDTO> getCurrentCart(){
        return currentCart;
    }

    public ItemDTO getCurrentItem(int position){
        
        return this.getCurrentCart().get(position);
    }
}