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
        assertEquals(existingID, result.getID(),"the itemIDs should match");

    }
    
    @Test
    void testFetchNotExistingItem(){
        int notExistingID = 0; 
        ItemInformationDTO result = inventory.fetchItemInformation(notExistingID);
        assertNull(result, "no item should be found, null should be returned");
    }

}
