package se.kth.iv1350.salesystem.integration;


import se.kth.iv1350.salesystem.controller.*;
import se.kth.iv1350.salesystem.integration.Printer;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.model.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PrinterTest {
   
    private Sale sale;
    private ItemInformationDTO itemInformation;
    private CashPayment payment;
    private Printer printer;
    private ReceiptDTO receipt;
    private String timeOfSale;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut = System.out;

    
   


    

    @BeforeEach
    public void setup(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printer = new Printer();
        sale = new Sale(); 
        itemInformation = new ItemInformationDTO("Baguette", new AmountDTO(29.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram.");
        sale.addToCart(1, itemInformation);

        payment = new CashPayment(sale, new AmountDTO(100));
        receipt = new ReceiptDTO(payment);

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        timeOfSale = sale.getDateTime().format(formatter);  
    }

    @Test
    public void testPrintReceipt(){
        printer.printReceipt(receipt);
        String output = outputStream.toString();
        
        String expectedTime = "Time of sale: " + timeOfSale;
        String excpectedNamePrice = String.format("%-20s %2d x %6.2f %8.2f %s\n", itemInformation.getName(), 1, 29.95, 29.95, "SEK");
        String excpectedTotal = String.format("\n Total: %.2f %s", 29.95+3.59, "SEK");


        assertTrue(output.contains("----- RECEIPT -----"), "Receipt titel is not printed correctly");
        assertTrue(output.contains(expectedTime), "Time of sale s not printed correctly");
        assertTrue(output.contains(excpectedNamePrice),
        "Item name and price is not printed correctly");        
        assertTrue(output.contains(excpectedTotal),"Total is not printed correctly");
        assertTrue(output.contains(" VAT: 3,59 SEK"), "VAT is not printed correctly");
        assertTrue(output.contains(" Cash: 100,00 SEK"), "Cash is not printed correctly");
        assertTrue(output.contains(" Change: 66,46 SEK"), "Change is not printed correctly");
        assertTrue(output.contains("----- END RECEIPT -----"), "END RECEIPT is not printed correctly");
    }
}
    