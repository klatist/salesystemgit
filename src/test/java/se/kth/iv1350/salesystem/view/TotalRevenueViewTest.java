package se.kth.iv1350.salesystem.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

import se.kth.iv1350.salesystem.controller.*;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.util.TotalRevenueFileOutput;

public class TotalRevenueViewTest {
    private TotalRevenueFileOutput observer;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp(){
        observer = new TotalRevenueFileOutput();

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
    public void testDoPrintTotalRevenue(){
        

    }
}