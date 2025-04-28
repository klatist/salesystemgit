package se.kth.iv1350.salesystem.model;
/**
 * This class holds all the information about an item.
 */
public class ItemInformationDTO {
    private String name;
    private Amount price;
    private int itemID;
    private double vatRate;
    private String description;

    /**
     * Creates the <code>ItemInformationDTO</code> 
     * @param name The namee of the item
     * @param price The price of the item
     * @param itemID The unique ideentifier
     * @param vatRate The VAT rate (percentage)
     * @param description A description of the item
     */
    public ItemInformationDTO(String name, Amount price, int itemID, double vatRate, String description)
    {
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.vatRate = vatRate;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public Amount getPrice(){
        return price;
    }

    public int getID(){
        return itemID;
    }

    public double getVATRate(){
        return vatRate;
    }

    public String getDescription(){
        return description;
    }

     
}