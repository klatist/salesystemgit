package se.kth.iv1350.salesystem.integration;
/**
 * Creates all the classes handling and giving access to the external systems Inventory, DiscountDatabase, 
 * Accounting and Pinter.
 */
public class ExternalSystemCreator {

    private ExternalInventory extInventory = new ExternalInventory();
    private DiscountDatabase discDatabase  = new DiscountDatabase(); 
    private ExternalAccounting extAccounting = new ExternalAccounting();
    private Printer printer = new Printer();

    /**
     * @return The external inventory system handler.
     */
    public ExternalInventory getExternalInventory() {
        return extInventory;
    }

    /**
     * @return The discount database handler.
     */
    public DiscountDatabase getDiscountDatabase(){
        return discDatabase;
    }

    /**
     * @return The external accounting system handler.
     */
    public ExternalAccounting getExternalAccounting(){
        return extAccounting;
    }

    /**
     * @return The printer to print receipts.
     */
    public Printer getPrinter(){
        return printer;
    }


}






