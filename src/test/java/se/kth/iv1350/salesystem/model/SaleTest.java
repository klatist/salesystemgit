package se.kth.iv1350.salesystem.model;

public class SaleTest {
    private Sale sale;
    ItemInformationDTO itemInformation;
    
/* 
    @BeforeEach
    public void setUp(){
        Item yoghurt = new Item(1, new ItemInformationDTO("Naturell Yoghurt", new AmountDTO(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram."));
        Item baguette = new Item(1, new ItemInformationDTO("Baguette", new AmountDTO(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"));
        itemInformation = new ItemInformationDTO("Kalaspuffar",new AmountDTO(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor");

        sale = new Sale();

        sale.getCart().add(yoghurt);
        sale.getCart().add(baguette);
    }

    @AfterEach
    public void tearDown(){
        sale = null;
    }

    @Test
public void testUpdateTotalPriceAndVAT() {
    sale.updateTotalPriceAndVAT();
    double newTotalPrice  = sale.getTotalPriceValue();
    double newTotalVAT = sale.getTotalVAT();

    double expTotalVAT = 25.95 * 0.12 + 15.50 * 0.12;
    double expTotalPrice = 25.95 + 15.50 + expTotalVAT;

    assertEquals(expTotalPrice, newTotalPrice, 0.001, "Total price including VAT should match expected value");
    assertEquals(expTotalVAT, newTotalVAT, 0.001, "Total VAT should match expected value");
}

    @Test
    public void testAddToCart() {
    sale.addToCart(1, itemInformation);
    int result = sale.getCart().findInCart(654321);
    assertEquals(2, result, "Item should be added at index 2 in the cart");
    }

    @Test
    public void testAddToEmptyCart() {
    Sale emptySale = new Sale();
    emptySale.addToCart(1, itemInformation);
    int result = emptySale.getCart().findInCart(654321);
    assertEquals(0, result, "Item added to empty cart should be at index 0");
    }

    @Test
    public void testAddToCartInvalidQuantity() {
    sale.addToCart(0, itemInformation);
    int result = sale.getCart().findInCart(654321);
    assertEquals(-1, result, "Item with quantity 0 should not be added to cart");
    }

    @Test
    public void testUpdateQuantity() {
    sale.updateQuantityInCart(0, 1);
    int result = sale.getCart().getItem(0).getItemQuantity();
    assertEquals(2, result, "Item quantity should be updated to 2 after adding 1");
    }

    @Test
    public void testUpdateQuantityQuantityZero() {
    sale.updateQuantityInCart(0, 0);
    int result = sale.getCart().getItem(0).getItemQuantity();
    assertEquals(1, result, "Item quantity should remain unchanged when 0 is added");
    }

    @Disabled
    @Test
    public void testUpdateQuantityInvalidPosition() {
    sale.updateQuantityInCart(-1, 0);
    int result = sale.getCart().getItem(-1).getItemQuantity();
    assertEquals(1, result, "Invalid index should not update quantity");
    }

    @Test
    public void testUpdateQuantityInvalidQuantity() {
    sale.updateQuantityInCart(0, -1);
    int result = sale.getCart().getItem(0).getItemQuantity();
    assertEquals(1, result, "Item quantity should remain unchanged when negative quantity causes invalid state");
    }
    */
}