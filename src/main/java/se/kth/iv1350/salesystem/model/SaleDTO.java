package se.kth.iv1350.salesystem.model;

import java.util.List;

public class SaleDTO {
    private Amount runningTotal;
    private double runningTotalVAT;
    private List<Item> currentCart;

    public SaleDTO(Sale sale){
        this.runningTotal = sale.getTotalPrice();
        this.runningTotalVAT = sale.getTotalVAT();
        this.currentCart = sale.getCart();
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

    public List<Item> getCurrentCart(){
        return currentCart;
    }

    public Item getCurrentItem(int position){
        
        return this.getCurrentCart().get(position);
    }
}