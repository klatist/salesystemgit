package se.kth.iv1350.salesystem.controller;

import se.kth.iv1350.salesystem.integration.ExternalSystemCreator;

public class ControllerTest {
    private Controller defaultContr;
    private ExternalSystemCreator defaultCreator;

/* 
    
    @BeforeEach
    public void setUp(){
        defaultCreator = new ExternalSystemCreator();
        defaultContr = new Controller(defaultCreator);

        defaultContr.startSale();
        
    }

    @AfterEach
    public void tearDown(){
        defaultCreator = null;
        defaultContr = null;
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
        int result = saleInformation.getCurrentCart().get(0).getItemQuantity();
        int cartSize = saleInformation.getCurrentCart().size();
        assertEquals(6, result, "If item added correctly, quantity should be updated to 6");
        assertEquals(1,cartSize,"Cart size should remain unchanged if itemID already existed in cart");
    }

    @Test
    public void testEndSale(){
        defaultContr.scanItem(123456, 2);
        defaultContr.scanItem(654321, 1);
        double expTotalVAT = 2*15.50*0.12 + 40.95*0.12;
        double expResult = 2*15.50+40.95+expTotalVAT;
        double result = defaultContr.endSale().getValue();
        assertEquals(expResult, result, "Actual total price should be equal expected total price");
    }

    @Test 
    public void testPayWithZero(){
        defaultContr.scanItem(12345, 2);
        defaultContr.scanItem(654321, 1);
        AmountDTO totalPrice = defaultContr.endSale();
        AmountDTO paidAmount = new AmountDTO(0);
        double result = defaultContr.pay(paidAmount).getValue();
        double expResult = 0-totalPrice.getValue();
        assertEquals(expResult, result, "Expected change should match actual change and be a negative value");
    }

    @Test
    public void testPayWithExactAmount(){
        defaultContr.scanItem(12345, 2);
        defaultContr.scanItem(654321, 1);
        AmountDTO totalPrice = defaultContr.endSale();
        AmountDTO paidAmount = new AmountDTO(totalPrice.getValue());
        double result = defaultContr.pay(paidAmount).getValue();
        assertEquals(0, result, "Actual change should be 0, since the paid amount and total price matches");
    }

    @Test 
    public void testPayWithLargerSum(){
        defaultContr.scanItem(12345, 2);
        defaultContr.scanItem(654321, 1);
        AmountDTO totalPrice = defaultContr.endSale();
        AmountDTO paidAmount = new AmountDTO(500);
        double expResult = 500-totalPrice.getValue();
        double result = defaultContr.pay(paidAmount).getValue();
        assertEquals(expResult, result, "Expected change should match the actual change, and it should be a positive value");
    }
*/
}
