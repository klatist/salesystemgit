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

    /**
     * Runs the program by making calls to the controller according to flow.
     */
    public void runSystem(){
        contr.startSale();

        SaleDTO saleInformation = contr.scanItem(123456, 2);
        if (saleInformation != null)
        {
            System.out.println("Item name " + saleInformation.getCurrentItemInformation().getName());
            System.out.println("Item desription " + saleInformation.getCurrentItemInformation().getDescription());
            System.out.println("Item price " + saleInformation.getCurrentItemInformation().getPrice());
            System.out.println("Running Total" + saleInformation.getRunningTotal());
        }
        else
        {
            System.out.println("itemID does not match an existing item");
        }

    }

    
}