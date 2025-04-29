package se.kth.iv1350.salesystem.model;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Item itemDefaultQuantity;
    private Item itemLargerQuantity;
    private ItemInformationDTO itemInformation;

    @BeforeEach
    public void setUp(){
        itemInformation = new ItemInformationDTO("Naturell Yoghurt", new AmountDTO(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram.");
        itemDefaultQuantity = new Item(1, itemInformation);
        itemLargerQuantity = new Item(3,itemInformation);
    }

    @AfterEach
    public void tearDown(){
        itemInformation = null;
        itemDefaultQuantity = null;
        itemLargerQuantity = null;
    }

    @Test
    public void testConstructor(){
        Item item = new Item(3,itemInformation);
        int result = item.getItemQuantity();
        assertEquals(3, result, "the default quantity should be 3");
    }

    @Test
    public void testCalculatePriceDefaultQuantity(){
        double result = itemDefaultQuantity.calculateItemPrice();
        double expPrice = 1 * itemDefaultQuantity.getItemValue();
        assertEquals(expPrice, result);
    }


    @Test
    public void testCalculatePriceLargerQuantity(){
        double result = itemLargerQuantity.calculateItemPrice();
        double expPrice = 3 * itemLargerQuantity.getItemValue();
        assertEquals(expPrice, result);
}

    @Test
    public void testcalculateItemVATDefaultCuantity(){
        double result = itemDefaultQuantity.calculateItemVAT();
        assertEquals(itemDefaultQuantity.getItemInformation().getVATRate() * itemDefaultQuantity.getItemValue(), result);
    }
    
    @Test
    public void testcalculateItemVATLargerCuantity(){
        double result = itemLargerQuantity.calculateItemVAT();
        assertEquals(itemLargerQuantity.getItemInformation().getVATRate() * itemLargerQuantity.getItemValue()* 3, result);
    }

    @Test
    public void testUpdateQuantityAddItem(){
        itemDefaultQuantity.updateQuantity(2); 
        assertEquals(3, itemDefaultQuantity.getItemQuantity());
    }

    @Test
    public void testUpdateQuantityRemoveItem(){
        itemLargerQuantity.updateQuantity(-1); 
        assertEquals(2, itemLargerQuantity.getItemQuantity());
    }

    @Test
    public void testUpdateQuantityInvalidQuantity(){
        itemDefaultQuantity.updateQuantity(-1); 
        assertEquals(1, itemDefaultQuantity.getItemQuantity());
    }

    @Test 
    public void testGetItemDTO(){
        ItemDTO result = itemDefaultQuantity.getItemDTO();
        assertTrue(result instanceof ItemDTO, "Result should be of object type ItemDTO");
    }
}
