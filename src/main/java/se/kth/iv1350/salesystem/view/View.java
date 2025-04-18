package se.kth.iv1350.salesystem.view; 

import se.kth.iv1350.salesystem.controller.Controller;
/**
 * The view class is a substitute for the user interface and makes calls to the controller to perform
 * the program functions. 
 */
public class View {

    private Controller contr;
    /**
     * Creates the view object.
     * @param contr The the program's controller
     */
    public View(Controller contr) {
        this.contr = contr;

    }

    
}