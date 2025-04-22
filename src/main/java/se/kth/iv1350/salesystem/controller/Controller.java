package se.kth.iv1350.salesystem.controller;

import se.kth.iv1350.salesystem.model.*;
import se.kth.iv1350.salesystem.integration.*;

/**
 The controller is a middle-layer between view to model and integration. The calls methods in model and integration 
 as a result of calls from the view layer.

 */

public class Controller {
    private ExternalInventory extInventory;
    private DiscountDatabase discdatabase;
    private ExternalAccounting extAccounting;
    private Printer printer;

    private Register register = new Register();
    
    /**
     * This creates an instance of the constructor object. 
     * @param creator The object which initializes the external systems: Inventory, DiscountDatabase,
     *  Accounting and Printer. 
     */
    public Controller(ExternalSystemCreator creator){
        this.extInventory = creator.getExternalInventory();
        this.discdatabase = creator.getDiscountDatabase();
        this.extAccounting = creator.getExternalAccounting();
        this.printer = creator.getPrinter();

    }

    private Sale sale; 
    /**
     * Creates the sale object to represent the sale. 
     */
    public void startSale()
    {
        sale = new Sale(); 
    }

    /**
     * Scans an item and 
     * @param itemID
     * @param itemQuantity
     * @return
     */
    public SaleDTO scanItem(int itemID, int itemQuantity){

        int position = sale.findInCart(itemID);

        if(position == -1){
            ItemInformationDTO itemInformation = fetchItemInformation(itemID);
            if(itemInformation != null){
                sale.addToCart(itemQuantity, itemInformation);
            }
            else

            
        }
        else
            sale.updateQuantityInCart(position, itemQuantity);

        
        SaleDTO saleInformation = sale.getSaleInformation();

        return saleInformation;
    }
}
