package se.kth.iv1350.salesystem.model;

public class ItemDTO {
    
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    /**
     * Constructor that creates an item with a specified quantity. 
     * @param itemQuantity Represents the quantity of the item.
     * @param itemInformation Represents information about the item such as name and price.
     */
    public ItemDTO(Item item){
        this.itemQuantity = item.getItemQuantity();
        this.itemInformation = item.getItemInformation();

    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public ItemInformationDTO getItemInformation(){
        return itemInformation;
    }

    public String getItemName(){
        return itemInformation.getName();
    }

    public AmountDTO getItemPrice(){
        return itemInformation.getPrice();
    }

    public double getItemValue(){
        return itemInformation.getPrice().getValue();
    }

    public int getItemID(){
        return itemInformation.getID();
    }

    public double getItemVATRate(){
        return itemInformation.getVATRate();
    }

    public String getItemDescription(){
        return itemInformation.getDescription();
    }

}