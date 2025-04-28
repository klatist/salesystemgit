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

    public double getTotalPriceValue(){
        return totalPrice.getValue();
    }
    
    public double getTotalVAT(){
        return totalVAT;
    }

    public List<Item> getCart(){
        return cart;
    }

    public Item getCurrentItem(int position){
        
        return this.getCart().get(position);
    }
}