package se.kth.iv1350.salesystem.integration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemIdentifierExceptionTest {
    private ExternalInventory inventory;

    @BeforeEach
    public void setUp(){
        inventory =  new ExternalInventory();
    }

    @AfterEach
    public void tearDown(){
        inventory = null;
    }

    @Test
    public void testItemIDNotInInventory(){
        try 
        {
            inventory.fetchItemInformation(555555);
            fail("Expected ItemIdentifierException to be thrown");
        } 
        
        catch (ItemIdentifierException exc) 
        {
            assertEquals(555555, exc.getInvalidItemIdentifier(), "Expects ItemID 555555 to throw ItemIdentifierException");
        }
    }

}
