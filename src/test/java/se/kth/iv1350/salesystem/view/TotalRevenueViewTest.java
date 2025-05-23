package se.kth.iv1350.salesystem.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

import se.kth.iv1350.salesystem.controller.*;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.view.TotalRevenueView;

public class TotalRevenueViewTest {
    private TotalRevenueView observer;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut = System.out;
    private AmountDTO totalRevenue;
    
    @BeforeEach
    public void setUp(){
        observer = new TotalRevenueView();
        totalRevenue = new AmountDTO(158.46);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach 
    public void tearDown(){
        observer = null;

        outputStream = null;
        System.setOut(originalOut);
    }

    @Test
    public void testDoPrintTotalRevenue() throws Exception{
        observer.doPrintTotalRevenue(totalRevenue);
        String expectedCurrency = totalRevenue.getCurrency().toString();
        String expectedOutput = String.format("\n Total Revenue: %.2f %s\n", totalRevenue.getValue(), expectedCurrency);

        String actualOutput = outputStream.toString();

        assertTrue(actualOutput.contains(expectedOutput), "Output should contain the formatted total revenue and currency.");
    }
}