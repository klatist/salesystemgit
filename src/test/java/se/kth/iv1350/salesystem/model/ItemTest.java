package se.kth.iv1350.salesystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Item itemDefaultQuantity;
    private Item itemLargerQuantity;
    private ItemInformationDTO itemInformation;

    @BeforeEach
    public void setUp(){
        itemInformation = new ItemInformationDTO("Naturell Yoghurt", new Amount(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram.");
        itemDefaultQuantity = new Item(itemInformation);
        itemLargerQuantity = new Item(3,itemInformation);
    }

    @Test
    public void testdefaultQuantityConstructor(){
        Item item = new Item(itemInformation);
        int result = item.getItemQuantity();
        assertEquals(1, result, "the default quantity should be 1");
    }

    @Test
    public void testConstructor(){
        Item item = new Item(3,itemInformation);
        int result = item.getItemQuantity();
        assertEquals(3, result, "the default quantity should be 3");
    }

    @Test
    public void testCalculatePriceDefaultQuantity(){
        double result = itemDefaultQuantity.calculateItemPrice().getAmount();
        double expPrice = 1 * itemDefaultQuantity.getItemInformation().getPrice().getAmount();
        assertEquals(expPrice, result);
    }


    @Test
    public void testCalculatePriceLargerQuantity(){
        double result = itemLargerQuantity.calculateItemPrice().getAmount();
        double expPrice = 3 * itemLargerQuantity.getItemInformation().getPrice().getAmount();
        assertEquals(expPrice, result);
}

    @Test
    public void testcalculateItemVATDefaultCuantity(){
        double result = itemDefaultQuantity.calculateItemVAT();
        assertEquals(itemDefaultQuantity.getItemInformation().getVATRate() * itemDefaultQuantity.getItemInformation().getPrice().getAmount(), result);
    }
    
    @Test
    public void testcalculateItemVATLargerCuantity(){
        double result = itemLargerQuantity.calculateItemVAT();
        assertEquals(itemLargerQuantity.getItemInformation().getVATRate() * itemLargerQuantity.getItemInformation().getPrice().getAmount() * 3, result);
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
    public void testUpdateQuantityToZero(){
        itemDefaultQuantity.updateQuantity(-1); 
        assertEquals(0, itemDefaultQuantity.getItemQuantity());
    }
}
