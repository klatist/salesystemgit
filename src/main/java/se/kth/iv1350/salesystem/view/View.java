package se.kth.iv1350.salesystem.view; 

import java.util.List;

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.controller.OperationFailedException;
import se.kth.iv1350.salesystem.integration.ItemIdentifierException;
import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.ItemDTO;
import se.kth.iv1350.salesystem.model.SaleDTO;
import se.kth.iv1350.salesystem.util.ExceptionLogger;
import se.kth.iv1350.salesystem.util.TotalRevenueFileOutput;

/**
 * The view class is a substitute for the user interface and makes calls to the controller to perform
 * the program functions. 
 */
public class View {

    private Controller contr;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private ExceptionLogger exceptionLogger = new ExceptionLogger();
    private TotalRevenueView revenueView = new TotalRevenueView();
    private TotalRevenueFileOutput revenueFileOutput = new TotalRevenueFileOutput();
    /**
     * Creates the view object.
     * @param contr The program's controller
     */
    public View(Controller contr) {
        this.contr = contr;
    }


   /**
    * Helper method that searches the cart for the item matching the scanned item ID
    * so the item's information can be printed after scanning.
    * @param saleInformation Current information about the sale, containing the cart of items
    * @param scannedItemID ItemID of the just scanned item. 
    * @return The <code>ItemDTO</code> corresponding to the scanned item ID, or <code>null</code> if no item is found.
    */

    private ItemDTO getItemFromCart(SaleDTO saleInformation, int scannedItemID){
        List<ItemDTO> cart = saleInformation.getCurrentCart();
        for(ItemDTO itemInCart : cart){
            if(itemInCart.getItemID() == scannedItemID){
                return itemInCart;
            }
        }
        return null;
    }
     /**
     * Runs the program by making calls to the controller according to flow.
     * The items to be scanned is placed in the list <code>itemIDs</code>.
     */

    public void runSystem(){
        contr.addRevenueObserver(revenueFileOutput);
        contr.addRevenueObserver(revenueView);
        
        contr.startSale();

        int[] itemIDs = {123456,654321,123456,000000};
        int[] quantities = {1, 2,2, 1};

        System.out.println("---- SALE -----");

        for(int i = 0; i < itemIDs.length; i++)
        {
            try 
            {
                SaleDTO saleInformation = contr.scanItem(itemIDs[i], quantities[i]);

                ItemDTO currentItem = getItemFromCart(saleInformation,itemIDs[i]);

                System.out.println("Item name: " + currentItem.getItemName());
                System.out.println("Item description: " + currentItem.getItemDescription());
                System.out.printf("Item price: %.2f", currentItem.getItemValue());
                System.out.printf("\nRunning Total: %.2f", saleInformation.getRunningTotalValue());
            } 

            catch (ItemIdentifierException exc) 
            {
                errorMessageHandler.showErrorMessage("Item could not be scanned, since itemID " + exc.getInvalidItemIdentifier() + " does not exist in inventory");
            }

            catch(OperationFailedException exc)
            {
                errorMessageHandler.showErrorMessage("System is unavailable");
            }

            catch(Exception exc)
            {
                errorMessageHandler.showErrorMessage("Failed to scan item. Please try again.");
                exceptionLogger.logException(exc);
            }
    
            System.out.println("\n");
        }

        AmountDTO finalTotalPrice = contr.endSale();
        System.out.println();
        System.out.printf("Total Cost: %.2f%n", finalTotalPrice.getValue());


        AmountDTO totalPriceAfterDiscount = contr.registerDiscount(0304050607);
        System.out.println();
        System.out.printf("Total Cost Discount Applied: %.2f%n", finalTotalPrice.getValue());


        AmountDTO paidAmount = new AmountDTO(200);
        AmountDTO change = contr.pay(paidAmount);
        
        contr.printReceipt();
        System.out.printf("Change: %.2f%n\n", change.getValue());

        /*//------------------------------Duplicerad sale-----------------------------------//
        contr.startSale();

        int[] itemIDs2 = {123456,654321,123456,000000};
        int[] quantities2 = {1, 2,2, 1};

        System.out.println("---- SALE -----");

        for(int i = 0; i < itemIDs.length; i++)
        {
            try 
            {
                SaleDTO saleInformation = contr.scanItem(itemIDs2[i], quantities2[i]);

                ItemDTO currentItem = getItemFromCart(saleInformation,itemIDs2[i]);

                System.out.println("Item name: " + currentItem.getItemName());
                System.out.println("Item description: " + currentItem.getItemDescription());
                System.out.printf("Item price: %.2f", currentItem.getItemValue());
                System.out.printf("\nRunning Total: %.2f", saleInformation.getRunningTotalValue());
            } 

            catch (ItemIdentifierException exc) 
            {
                errorMessageHandler.showErrorMessage("Item could not be scanned, since itemID " + exc.getInvalidItemIdentifier() + " does not exist in inventory");
            }

            catch(OperationFailedException exc)
            {
                errorMessageHandler.showErrorMessage("System is unavailable");
            }

            catch(Exception exc)
            {
                errorMessageHandler.showErrorMessage("Failed to scan item. Please try again.");
                exceptionLogger.logException(exc);
            }
    
            System.out.println("\n");
        }

        AmountDTO finalTotalPrice2 = contr.endSale();
        System.out.println();
        System.out.printf("Total Cost: %.2f%n", finalTotalPrice2.getValue());

        AmountDTO paidAmount2 = new AmountDTO(200);
        AmountDTO change2 = contr.pay(paidAmount2);
        
        contr.printReceipt();
        System.out.printf("Change: %.2f%n\n", change2.getValue());*/
    }

    
}