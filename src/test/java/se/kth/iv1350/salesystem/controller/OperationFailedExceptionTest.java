package se.kth.iv1350.salesystem.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import se.kth.iv1350.salesystem.integration.ItemIdentifierException;
import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;


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
    public void testOperationFailedException(){
        contr.startSale();
        try
        {
            contr.scanItem(000000, 1);
            fail("Expected OperationFailedException to be thrown");
        }
        catch(OperationFailedException exc)
        {
            
        }
        catch(ItemIdentifierException itemExc)
        {
            fail("Did not expect ItemIdentifierException to be thrown");
        }
    }

    
}
