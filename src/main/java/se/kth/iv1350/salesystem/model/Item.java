package se.kth.iv1350.salesystem.model;


public class Item {
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    public Item(int itemQuantity, ItemInformationDTO itemInformation){
        this.itemQuantity = itemQuantity;
        this.itemInformation = itemInformation;

    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public ItemInformationDTO getItemInformation(){
        return itemInformation;
    }

    Amount calculateItemPrice(){
        Amount itemPriceAmount = this.getItemInformation().getPrice();
        
        return itemPriceAmount.multiply(itemQuantity);

    }

    double calculateItemVAT(){

        return this.getItemInformation().getPrice().getAmount() * this.getItemInformation().getVATRate() * this.itemQuantity;

    }

    void updateQuantity(int newItemQuantity){
        this.itemQuantity += newItemQuantity;
    }
    
}
