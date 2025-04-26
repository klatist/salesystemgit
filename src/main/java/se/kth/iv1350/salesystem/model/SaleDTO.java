package se.kth.iv1350.salesystem.model;

import java.util.List;

public class SaleDTO {
    private Amount totalPriceExcVAT;
    private double totalVAT;
    private List<Item> cart;

    public SaleDTO(Sale sale){
        this.totalPriceExcVAT = sale.getTotalPriceExcVAT();
        this.totalVAT = sale.getTotalVAT();
        this.cart = sale.getCart();
    }

    public Amount getTotalPriceExcVAT(){
        return totalPriceExcVAT;
    }
    
    public double getTotalVAT(){
        return totalVAT;
    }

    public double getRunningTotal(){
        return totalPriceExcVAT.getAmount() + totalVAT;
    }

    public List<Item> getCart(){
        return cart;
    }

    public Item getCurrentItem(int position){
        
        return this.getCart().get(position);
    }
}