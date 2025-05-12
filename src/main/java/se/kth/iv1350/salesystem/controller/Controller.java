package se.kth.iv1350.salesystem.controller;

import se.kth.iv1350.salesystem.integration.DatabaseFailureException;
import se.kth.iv1350.salesystem.integration.DiscountDatabase;
import se.kth.iv1350.salesystem.integration.ExternalAccounting;
import se.kth.iv1350.salesystem.integration.ExternalInventory;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.integration.ItemIdentifierException;
import se.kth.iv1350.salesystem.integration.Printer;
import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.CashPayment;
import se.kth.iv1350.salesystem.model.ItemInformationDTO;
import se.kth.iv1350.salesystem.model.Register;
import se.kth.iv1350.salesystem.model.Sale;
import se.kth.iv1350.salesystem.model.SaleDTO;
import se.kth.iv1350.salesystem.util.LogHandler;
;

/**
 The controller is a middle-layer between view to model and integration. The calls methods in model and integration 
 as a result of calls from the view layer.
 */

public class Controller {
    private ExternalInventory extInventory;
    private DiscountDatabase discdatabase;
    private ExternalAccounting extAccounting;
    private Printer printer;

    private Register register = new Register(0);
    private LogHandler logger = new LogHandler();
    
    /**
     * This creates an instance of the constructor object. 
     * @param creator The object which initializes the external systems.
     */
    public Controller(ExternalSystemCreator creator){
        this.extInventory = creator.getExternalInventory();
        this.discdatabase = creator.getDiscountDatabase();
        this.extAccounting = creator.getExternalAccounting();
        this.printer = creator.getPrinter();
    }

    private Sale sale; 
    private CashPayment payment;

    /**
     * Creates the <code>sale</code> object to represent and hold information about the sale. 
     */
    public void startSale()
    {
        sale = new Sale(); 
    }

    /**
     * Scans an item and updates the <code>sale</code> with the <code>itemInformation</code> and quantity. 
     * Checks if the item already exists in the cart list, (represented by <code>position</code>)
     * If so, the quantity is updated. Otherwise, the item is fetched from the external inventory and added to the cart.
     *
     * @param itemID The identifier for the item to be scanned.
     * @param itemQuantity The quantity of the item to be added to the cart.
     * @throws ItemIdentifierException  if the itemID does not exist in inventory.
     * @throws OperationFailedException  if the database for some reason could not be called as expected.
     * @return A <code>SaleDTO</code> representing the sale in the moment after the item is scanned, or <code>null</code> if the item is not found in inventory.
     */
    public SaleDTO scanItem(int itemID, int itemQuantity) throws ItemIdentifierException, OperationFailedException{

        int position = sale.findInCart(itemID);

        try 
        {
            if(position == -1){
    
                ItemInformationDTO itemInformation = extInventory.fetchItemInformation(itemID);
                sale.addToCart(itemQuantity, itemInformation);
               
            }
            else{
                sale.updateQuantityInCart(position, itemQuantity);
            }

            SaleDTO saleInformation = sale.getSaleInformation();
            return saleInformation; 
        } 

        catch (DatabaseFailureException databExc) 
        {
            logger.log(databExc);
            throw new OperationFailedException(databExc);
        }
    
    }

    /**
     * Ends the sale instance and presents the total price incl VAT.
     * @return The total price for the sale
     */

    public AmountDTO endSale()
    {
        return sale.getTotalPrice();
    }


    /**
    * Handles the payment for the sale.
    * Fetches information about the purchase (<code>finalSaleInformation</code>) and updates external systems.
    * Initiates a <code>CashPayment</code> and get the change.
    * Updates the register balance with the total price for the sale.
     * @param paidAmount The amount customer gives as payment
     * @return The amount of change to give to the customer.
     */

    public AmountDTO pay(AmountDTO paidAmount){

        SaleDTO finalSaleInformation = sale.getSaleInformation();
        extAccounting.updateAccounting(finalSaleInformation);
        extInventory.updateInventory(finalSaleInformation);

        payment = new CashPayment(sale, paidAmount);
        AmountDTO change = payment.getChange();

        register.updateBalance(finalSaleInformation.getRunningTotal());
        return change;
    }

    /**
     * Prints the receipt with information from the sale.
     */
    public void printReceipt(){
        payment.printReceipt(printer);
    }
}

