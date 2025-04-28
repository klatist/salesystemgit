package se.kth.iv1350.salesystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SaleTest {
    private Sale sale;
    

    @BeforeEach
    public void setUp(){
        Item yoghurt = new Item(new ItemInformationDTO("Naturell Yoghurt", new Amount(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram."));
        Item baguette = new Item(new ItemInformationDTO("Baguette", new Amount(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"));
        
        sale = new Sale();

        sale.getCart().add(yoghurt);
        sale.getCart().add(baguette);
    }

    @Test
    public void testUpdateTotalPriceAndVAT(){
        sale.updateTotalPriceAndVAT();
        double newTotalPrice  = sale.getTotalPriceValue();
        double newTotalVAT = sale.getTotalVAT();

        double expTotalVAT = 25.95*0.12 + 15.50*0.12;
        double expTotalPrice =  25.95 + 15.50 + expTotalVAT;
        
        assertEquals(expTotalPrice, newTotalPrice);
        assertEquals(expTotalVAT, newTotalVAT);
    }

    @Test
    public void testAddToCartItemIDInCart(){
        int itemID = 123456;
        int result = sale.findInCart(itemID);
        assertTrue(result != -1, "the item should have an index in cart");
    }


    @Test
    public void testAddToCartItemIDNotInCart(){
        int itemID = 000000;
        int result = sale.findInCart(itemID);
        assertTrue(result == -1, "the item should not have an index in cart");
    }
    
    @Test
    public void testAddToCart(){
        ItemInformationDTO itemInformation = new ItemInformationDTO("Kalaspuffar",new Amount(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor");
        sale.addToCart(1, itemInformation);
        int result = sale.findInCart(654321);
        assertEquals(2, result);
    }

    @Test
    public void testAddToEmptyCart(){
        Sale emptySale = new Sale();
        ItemInformationDTO iteminformation = new ItemInformationDTO("Kalaspuffar",new Amount(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor");
        emptySale.addToCart(1, iteminformation);
        int result = emptySale.findInCart(654321);
        assertEquals(0, result, "If item was added to an empty cart it should be at index 0");
    }

    @Test
    public void testAddToCartInvalidQuantity(){
        ItemInformationDTO itemInformation = new ItemInformationDTO("Kalaspuffar",new Amount(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor");
        sale.addToCart(0, itemInformation);
        int result = sale.findInCart(654321);
        assertEquals(-1, result);

    }

    @Test
    public void testUpdateQuantity(){
        sale.updateQuantityInCart(0, 1);
        int result = sale.getCart().get(0).getItemQuantity();
        assertEquals(2, result);
    }

    @Test
    public void testUpdateQuantityQuantityZero(){
        sale.updateQuantityInCart(0, 0);
        int result = sale.getCart().get(0).getItemQuantity();
        assertEquals(1, result);
    }

    @Disabled
    @Test
    public void testUpdateQuantityInvalidPosition(){
        sale.updateQuantityInCart(-1, 0);
        int result = sale.getCart().get(-1).getItemQuantity();
        assertEquals(1, result);
    }

    @Test
    public void testUpdateQuantityInvalidQuantity(){
        sale.updateQuantityInCart(0, -1);
        int result = sale.getCart().get(0).getItemQuantity();
        assertEquals(1, result);
    }
}
