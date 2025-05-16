package se.kth.iv1350.salesystem.integration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseFailureExceptionTest{
    private ExternalInventory extInventory;

    @BeforeEach
    public void setUp(){
       extInventory = new ExternalInventory();
       
    }

    @AfterEach
    public void tearDown(){
        extInventory = null;
    }

    @Test
    public void testDatabaseNotAvailable() throws ItemIdentifierException{
        try {
            extInventory.fetchItemInformation(000000);
            fail("Expected DatabaseFailureException to be thrown");
        }
        
        catch (DatabaseFailureException exc) 
        {
            assertEquals("Database can not be called.", exc.getMessage(), "Expects DatabaseFailureException to be thrown if fetchItemInformation gets itemID 000000");
        }
    }

}