package se.kth.iv1350.salesystem.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesystem.model.*;

public class ExternalInventoryTest {

    private ExternalInventory inventory;
    
    @BeforeAll
    public static void setUpClass(){

    }

    @AfterAll
    public static void tearDownClass(){
        
    }
    
    //private variabler

    @BeforeEach
    public void setUp(){
        inventory =  new ExternalInventory();
    }

    @AfterEach
    public void tearDown(){
        inventory = null;
    }

    @Test
    void testFetchExistingItem(){
        int existingID = 123456;

        
        ItemInformationDTO result = inventory.fetchItemInformation(existingID);
        assertNotNull(result, "Item should exist in inventory");
        assertTrue(result instanceof ItemInformationDTO, "Item should be of the type ItemInformationDTO");
        assertEquals(existingID, result.getItemID(),"the itemIDs should match");
        assertEquals("Baguette", result.getName(),"the item names should match");
        assertEquals(15.50, result.getPrice().getAmount(),"the item price should match");
        assertEquals(0.12, result.getVATRate(),"the item VAT rate should match");
        assertEquals("Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram", result.getDescription(),"the item description should match");
    }

    @Test
    void testFetchNotExistingItem(){
        int notExistingID = 0; 
        ItemInformationDTO result = inventory.fetchItemInformation(notExistingID);
        assertNull(result, "no item should be found, null should be returned");
    }

}
