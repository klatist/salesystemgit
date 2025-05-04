package se.kth.iv1350.salesystem.model;

/**
 * This class represents the items that has been scanned during sale.
 */

class Item {
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    /**
     * Constructor that creates an item with a specified quantity. 
     * @param itemQuantity Represents the quantity of the item.
     * @param itemInformation Represents information about the item such as name and price.
     */
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
    
    double getItemValue(){
        return itemInformation.getPrice().getValue();
    }

    int getItemID(){
        return itemInformation.getID();
    }

    double getItemVATRate(){
        return itemInformation.getVATRate();
    }

    ItemDTO getItemDTO(){
        ItemDTO itemDTO = new ItemDTO(this);
        return itemDTO;
    }

    /**
     * Calculates the total price for the current item.
     * @return returns the total price <code>Amount</code> for the item.
     */
    double calculateItemPrice(){
        double itemPriceAmount = this.getItemValue();
        return itemPriceAmount * itemQuantity;

    }

    /**
     * Calculates the total VAT for the current item.
     * @return returns the total VAT for the item.
     */
    double calculateItemVAT(){

        return this.getItemValue() * this.getItemVATRate() * this.itemQuantity;

    }

    /**
     * Updates the quantity of the item.
     * 
     * @param newItemQuantity Represents the quantity to be added.
     */
    void updateQuantity(int newItemQuantity){
        if (this.itemQuantity + newItemQuantity > 0){
            this.itemQuantity += newItemQuantity;
        }
    }
    
}
