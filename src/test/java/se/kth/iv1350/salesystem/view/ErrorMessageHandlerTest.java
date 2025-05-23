package se.kth.iv1350.salesystem.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

import se.kth.iv1350.salesystem.controller.*;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;

public class ErrorMessageHandlerTest{
    private ErrorMessageHandler errorMessageHandler;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        errorMessageHandler = new ErrorMessageHandler();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown(){
        errorMessageHandler = null;
        outputStream = null;
        System.setOut(originalOut);
    }

    @Test
    public void testShowErrorMessage(){
        String errorMessage = "Something went wrong.";
        errorMessageHandler.showErrorMessage(errorMessage);

        String output = outputStream.toString();
        assertTrue(output.contains(errorMessage), "The error message should be printed to System.out");
    }
}