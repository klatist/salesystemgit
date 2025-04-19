package se.kth.iv1350.salesystem.model;

public class Item {
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    Item(int itemQuantity, ItemInformationDTO itemInformation){
        this.itemQuantity = itemQuantity;
        this.itemInformation = itemInformation;

    }

    int getItemQuantity(){
        return itemQuantity;
    }

    ItemInformationDTO getItemInformation(){
        return itemInformation;
    }
    
}
