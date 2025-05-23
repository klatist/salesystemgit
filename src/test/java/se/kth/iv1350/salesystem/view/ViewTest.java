package se.kth.iv1350.salesystem.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

import se.kth.iv1350.salesystem.controller.*;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;

public class ViewTest {
    private ExternalSystemCreator creator;
    private Controller contr;
    private View view;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        creator = new ExternalSystemCreator();
        contr = new Controller(creator);
        view = new View(contr);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown(){
        creator = null;
        contr = null;
        view = null;

        outputStream = null;
        System.setOut(originalOut);
    }

    @Test
    public void testRunSystemOutput(){
        view.runSystem();
        String output = outputStream.toString();
        assertTrue(output.contains("---- SALE -----"), "Output should contain start of sale text");
        assertTrue(output.contains("Item name: Baguette"), "Output should contain name of first item in cart.");
        assertTrue(output.contains("Item description: Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"), 
                            "Output should contain description of the first item in cart");
        assertTrue(output.contains("Item price: 15,50"), "Output should contain item price of the first item in cart");
        assertTrue(output.contains("Running Total: 17,36"), "Output should contain the right running total after first item scanned");
        assertTrue(output.contains("Total Cost: 143,81"), "Output should contain the total cost of the first sale");
        assertTrue(output.contains("Total Cost Discount Applied: 115,24"),
                            "Output should contain the right total cost after discount applied from the first sale.");
        assertTrue(output.contains("Change: 84,76"), "Output should contain the right change amount from payment in the first sale.");

    }
}
