package se.kth.iv1350.salesystem.controller;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;
import se.kth.iv1350.salesystem.model.Sale;
import se.kth.iv1350.salesystem.model.SaleDTO;

public class ControllerTest {
    private Controller defaultContr;
    private ExternalSystemCreator defaultCreator;
    private Sale sale;


    
    @BeforeEach
    public void setUp(){
        defaultCreator = new ExternalSystemCreator();
        defaultContr = new Controller(defaultCreator);

        defaultContr.startSale();
        
    }

    @AfterEach
    public void tearDown(){

    }

    @Test 
    public void testStartSale(){
        defaultContr.startSale();
        SaleDTO saleInformation = defaultContr.scanItem(123456, 2);
        assertNotNull(saleInformation, "Saleinformation should not be null");
    }

    @Test 
    public void testScanItemAddToEmptyCart(){
        SaleDTO saleInformation = defaultContr.scanItem(654321, 1);
        int result = saleInformation.getCurrentItem(0).getItemID();
        assertEquals(654321, result, "ItemIDs should match if item was added correctly to the cart");
    }


    @Test 
    public void testScanItemNotInInventory(){
        SaleDTO result = defaultContr.scanItem(000000, 1);
        assertNull(result, "Should return null if itemID not found in inventory");
    }

    @Test 
    public void testScanItemAlreadyInCart(){
        defaultContr.scanItem(123456, 1);

        SaleDTO saleInformation = defaultContr.scanItem(123456, 5);
        int result = saleInformation.getCart().get(0).getItemQuantity();
        int cartSize = saleInformation.getCart().size();
        assertEquals(6, result, "If item added correctly, quantity should be updated to 6");
        assertEquals(1,cartSize,"Cart size should remain unchanged if itemID already existed in cart");
    }

}
