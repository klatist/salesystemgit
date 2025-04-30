package se.kth.iv1350.salesystem.integration;

import java.time.format.DateTimeFormatter;
import java.util.List;

import se.kth.iv1350.salesystem.model.ItemDTO;
import se.kth.iv1350.salesystem.model.ReceiptDTO;
/**
 * This class prints a receipt containing saleinformation after a completd sale.  
 */
public class Printer {

    /**
     * Prints the recipt containing time of sale, list of items, total amount and VAT, the amount paid and given change.
     * @param receipt <code>ReceeiptDTO</code> containing all information about the sale. 
     */

    public void printReceipt(ReceiptDTO receipt){
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("----- RECEIPT -----");
        System.out.println("Time of sale: " + receipt.getDateTime().format(formatter));
        System.out.println();

        printCart(receipt.getCart());

        System.out.printf("\n Total: %.2f %s", 
            receipt.getFinalTotalPriceValue(), 
            receipt.getFinalTotalPrice().getCurrency().toString());

        System.out.printf("\n VAT: %.2f %s",
            receipt.getFinalTotalVAT(),
            receipt.getFinalTotalPrice().getCurrency().toString());

        System.out.printf("\n Cash: %.2f %s",
            receipt.getPaidAmount().getValue(),
            receipt.getFinalTotalPrice().getCurrency().toString());

        System.out.printf("\n Change: %.2f %s",
            receipt.getChange().getValue(),
            receipt.getFinalTotalPrice().getCurrency().toString());

        System.out.println();
        System.out.println("----- END RECEIPT -----");

    }
    /**
     * Helpmethod to print the name, quantity, price, combined price and currency of each item .  
     * @param cart Represent the list of bought items with quantities. 
     */
    private void printCart(List<ItemDTO> cart){
        for(ItemDTO item : cart){
            System.out.printf("%-20s %2d x %6.2f %8.2f %s\n", 
                item.getItemName(),
                item.getItemQuantity(),
                item.getItemValue(),
                item.getItemQuantity() * item.getItemValue(),
                item.getItemPrice().getCurrency().toString());
        }
    }
}
