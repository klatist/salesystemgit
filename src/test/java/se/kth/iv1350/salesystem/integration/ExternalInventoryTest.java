package se.kth.iv1350.salesystem.integration;

public class ExternalInventoryTest {

    private ExternalInventory inventory;
    
    /* 

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
*/
}
