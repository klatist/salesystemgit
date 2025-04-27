package se.kth.iv1350.salesystem.model;


public class Item {
    private int itemQuantity;
    private ItemInformationDTO itemInformation;

    /**
     * Constructor that creates an item with a specified quantity. 
     * @param itemQuantity Represents the quantity of the item.
     * @param itemInformation Represents information about the item such as name and price.
     */
    public Item(int itemQuantity, ItemInformationDTO itemInformation){
        this.itemQuantity = itemQuantity;
        this.itemInformation = itemInformation;

    }
    /**
     * Constructor that creates an item with the deafult value 1.  
     * @param itemQuantity Represents the quantity of the item.
     */
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

    public String getName(){
        return itemInformation.getName();
    }

    public Amount getPrice(){
        return itemInformation.getPrice();
    }

    public double getPriceAmount(){
        return itemInformation.getPrice().getAmount();
    }

    public int getItemID(){
        return itemInformation.getItemID();
    }

    public double getVATRate(){
        return itemInformation.getVATRate();
    }

    public String getDescription(){
        return itemInformation.getDescription();
    }


    /**
     * Calculates the total price for the current item.
     * @return returns the total price <code>Amount</code> for the item.
     */
    Amount calculateItemPrice(){
        Amount itemPriceAmount = this.getPrice();

        return itemPriceAmount.multiply(itemQuantity);

    }

    /**
     * Calculates the total VAT for the current item.
     * @return returns the total VAT for the item.
     */
    double calculateItemVAT(){

        return this.getPriceAmount() * this.getVATRate() * this.itemQuantity;

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
