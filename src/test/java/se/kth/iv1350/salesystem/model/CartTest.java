package se.kth.iv1350.salesystem.model;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {
    Cart cart;
    
    @BeforeEach
    public void setUp(){
        Item yoghurt = new Item(2, new ItemInformationDTO("Naturell Yoghurt", new AmountDTO(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram."));
        Item baguette = new Item(1, new ItemInformationDTO("Baguette", new AmountDTO(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vattTypeAnnotation.en, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"));
        cart = new Cart();
        cart.add(yoghurt);
        cart.add(baguette);
    }

    @AfterEach
    public void tearDown(){
        cart = null;
    }

    @Test
    public void testToItemDTOCart(){
        int expResult = cart.getItem(0).getItemID();
        List<ItemDTO> cartDTO = cart.toItemDTOCart();
        int result = cartDTO.get(0).getItemID();
        assertEquals(expResult, result, "If list converted correctly, itemIDs for the items on the same position should match");
    }

    @Test
    public void testFindInCartItemExistsInCart(){
       int result = cart.findInCart(222222);
        assertEquals(0, result, "Yoghurt should exist at position 0");
    }

    @Test
    public void testFindInCartItemNotInCart(){
        Item kalaspuffar = new Item(1, new ItemInformationDTO("Kalaspuffar",new AmountDTO(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor. 500 gram"));
        int result = cart.findInCart(654321);
        assertEquals(-1, result, "Item should not exist in cart, result should be -1");
    }


    


    
}
