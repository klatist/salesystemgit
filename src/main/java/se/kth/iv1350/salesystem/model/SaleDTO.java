package se.kth.iv1350.salesystem.model;

import java.util.List;

public class SaleDTO {
    private Amount totalSalePrice;
    private double totalSaleVAT;
    private List<Item> currentCart;

    public SaleDTO(Sale sale){
        this.totalSalePrice = sale.getTotalPrice();
        this.totalSaleVAT = sale.getTotalVAT();
        this.currentCart = sale.getCart();
    }

    public Amount getSaleTotalPrice(){
        return totalSalePrice;
    }

    public double getTotalSalePriceValue(){
        return totalSalePrice.getValue();
    }
    
    public double getTotaSaleVAT(){
        return totalSaleVAT;
    }

    public List<Item> getCurrentCart(){
        return currentCart;
    }

    public Item getCurrentItem(int position){
        
        return this.getCurrentCart().get(position);
    }
}