package se.kth.iv1350.salesystem.view; 

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.model.SaleDTO;

/**
 * The view class is a substitute for the user interface and makes calls to the controller to perform
 * the program functions. 
 */
public class View {

    private Controller contr;
    /**
     * Creates the view object.
     * @param contr The program's controller
     */
    public View(Controller contr) {
        this.contr = contr;

    }

    public void runSystem(){
        contr.startSale();

        SaleDTO saleInformation = contr.scanItem(itemID, itemQuantity);
        if (saleInformation != null)
        {
            System.out.println("Item name " + saleInformation.currentItemInformation().getName());
            System.out.println("Item desription " + saleInformation.currentItemInformation().getDescription());
            System.out.println("Item price " + saleInformation.currentItemInformation().getPrice());
            System.out.println("Running Total" + saleInformation.getRunningTotal());
        }
        else
        {
            System.out.println("itemID does not match an existing item");
        }

    }

    
}