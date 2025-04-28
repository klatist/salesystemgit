package se.kth.iv1350.salesystem.startup;

import se.kth.iv1350.salesystem.controller.Controller;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.view.View;

/**
 * Main is used to start to start the program
 */
public class Main {
    /**
     * The main method starts the program by initiating the view, controller and externalSystemCreator. 
     * @param args It does not take any arguments.
     */
    public static void main(String[] args) {
        
        ExternalSystemCreator creator = new ExternalSystemCreator();
        Controller contr = new Controller(creator);
        View view = new View(contr);
        view.runSystem();
        System.out.println("det fungeerar");
    }

}
