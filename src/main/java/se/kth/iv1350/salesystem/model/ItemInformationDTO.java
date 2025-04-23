package se.kth.iv1350.salesystem.model;

public class ItemInformationDTO {
    private String name;
    private Amount price;
    private int itemID;
    private double vatRate;
    private String description;

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

    public int getItemID(){
        return itemID;
    }

    public double getVATRate(){
        return vatRate;
    }

    public String getDescription(){
        return description;
    }

     
}