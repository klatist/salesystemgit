package se.kth.iv1350.salesystem.controller;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.salesystem.integration.DatabaseFailureException;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.integration.ItemIdentifierException;


public class OperationFailedExceptionTest {
    private Controller contr;
    private ExternalSystemCreator creator;
    

    @BeforeEach
    public void setUp(){
        ExternalSystemCreator creator = new ExternalSystemCreator();
        contr = new Controller(creator);
    }

    @AfterEach
    public void tearDown(){
        creator = null;
        contr = null;
    }

    @Test
    public void testOperationFailedException() throws ItemIdentifierException{
        contr.startSale();
        try
        {
            contr.scanItem(000000, 1);
            fail("Expected OperationFailedException to be thrown");
        }
        catch(OperationFailedException exc)
        {
            Throwable cause = exc.getCause();
            assertTrue(cause instanceof DatabaseFailureException, "Expected cause to be DatabaseFailureExpection");
        }
    }

    
}
