package se.kth.iv1350.salesystem.model;

import java.util.List;

public class SaleDTO {
    private Amount totalPrice;
    private double totalVAT;
    private List<Item> cart;

    public SaleDTO(Sale sale){
        this.totalPrice = sale.getTotalPrice();
        this.totalVAT = sale.getTotalVAT();
        this.cart = sale.getCart();
    }

    public Amount getTotalPrice(){
        return totalPrice;
    }
    
    public double getTotalVAT(){
        return totalVAT;
    }

    public double getRunningTotal(){
        return totalPrice.getAmount() + totalVAT;
    }

    public List<Item> getCart(){
        return cart;
    }

    
}