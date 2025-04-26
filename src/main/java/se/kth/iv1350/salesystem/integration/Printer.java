package se.kth.iv1350.salesystem.integration;

import java.util.List;

import se.kth.iv1350.salesystem.model.Item;
import se.kth.iv1350.salesystem.model.ReceiptDTO;
/**
 * The printer prints a receipt containing saleinformation after a completd sale.  
 */
public class Printer {

    public void printReceipt(ReceiptDTO receipt){
        System.out.println("----- RECEIPT -----");
        System.out.println("Time of sale: " + receipt.getDateTime());
        System.out.println();
        printCart(receipt.getCart());

        
        System.out.printf("\n Total: %.2f %s", 
            receipt.getTotalPriceAmount(), 
            receipt.getTotalPrice().getCurrency().toString());

        System.out.printf("\n VAT: %.2f %s",
            receipt.getTotalVAT(),
            receipt.getTotalPrice().getCurrency().toString());

        System.out.printf("\n Cash: %.2f %s",
            receipt.getPaidAmount().getAmount(),
            receipt.getTotalPrice().getCurrency().toString());

        System.out.printf("\n Change: %.2f %s",
            receipt.getChange().getAmount(),
            receipt.getTotalPrice().getCurrency().toString());

    }
    
    private void printCart(List<Item> cart){
        for(Item item : cart){
            System.out.printf("%-20s %2d x %6.2f %8.2f %s\n", 
                item.getName(),
                item.getItemQuantity(),
                item.getPriceAmount(),
                item.getItemQuantity()*item.getPriceAmount(),
                item.getPrice().getCurrency().toString());
        }
    }
}
