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

        int[] itemIDs = {123456, };
        int[] quantities = {1, };

        for(int i = 0; i < itemIDs.length; i++)
        {
            SaleDTO saleInformation = contr.scanItem(itemIDs[i], quantities[i]);

            if (saleInformation != null)
            {
                int currentItemPosition = saleInformation.getCart().size()-1;
                System.out.println("Item name " + saleInformation.getCurrentItem(currentItemPosition).getName());
                System.out.println("Item desription " + saleInformation.getCurrentItem(currentItemPosition).getDescription());
                System.out.println("Item price " + saleInformation.getCurrentItem(currentItemPosition).getPrice());
                System.out.println("Running Total" + saleInformation.getRunningTotal());
            }
            else
            {
                System.out.println("itemID " + itemIDs[i] + "does not match an existing item");
            }
        }
    }

    
}