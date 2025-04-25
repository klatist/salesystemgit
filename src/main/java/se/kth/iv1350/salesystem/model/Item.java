package se.kth.iv1350.salesystem.model;


public class Item {
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    /**
     * Constructor that creates an item.
     * @param itemQuantity Represents the quantity of the item.
     * @param itemInformation Represents information about the item such as name and price.
     */
    public Item(int itemQuantity, ItemInformationDTO itemInformation){
        this.itemQuantity = itemQuantity;
        this.itemInformation = itemInformation;

    }
    public Item(ItemInformationDTO itemInformation){
        this.itemQuantity = 1;
        this.itemInformation = itemInformation;

    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public ItemInformationDTO getItemInformation(){
        return itemInformation;
    }


    /**
     * Calculates the total price for the current item.
     * @return returns the total price <code>amount</code> for the item.
     */
    Amount calculateItemPrice(){
        Amount itemPriceAmount = this.getItemInformation().getPrice();
        
        return itemPriceAmount.multiply(itemQuantity);

    }

    /**
     * Calculates the total VAT for the current item.
     * @return returns the total VAT for the item.
     */
    double calculateItemVAT(){

        return this.getItemInformation().getPrice().getAmount() * this.getItemInformation().getVATRate() * this.itemQuantity;

    }

    /**
     * Updates the quantity of the item.
     * 
     * @param newItemQuantity Represents the quantity to be added.
     */
    void updateQuantity(int newItemQuantity){
        this.itemQuantity += newItemQuantity;
    }
    
}
