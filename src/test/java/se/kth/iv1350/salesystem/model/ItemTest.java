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
public void testConstructor() {
    Item item = new Item(3, itemInformation);
    int result = item.getItemQuantity();
    assertEquals(3, result, "Constructor should set item quantity to 3");
}

@Test
public void testCalculatePriceDefaultQuantity() {
    double result = itemDefaultQuantity.calculateItemPrice();
    double expectedPrice = 1 * itemDefaultQuantity.getItemValue();
    assertEquals(expectedPrice, result, 0.001, "Price for default quantity (1) is incorrect");
}

@Test
public void testCalculatePriceLargerQuantity() {
    double result = itemLargerQuantity.calculateItemPrice();
    double expectedPrice = 3 * itemLargerQuantity.getItemValue();
    assertEquals(expectedPrice, result, 0.001, "Price for quantity 3 is incorrect");
}

@Test
public void testCalculateItemVATDefaultQuantity() {
    double expectedVAT = itemDefaultQuantity.getItemInformation().getVATRate() * itemDefaultQuantity.getItemValue();
    double result = itemDefaultQuantity.calculateItemVAT();
    assertEquals(expectedVAT, result, 0.001, "VAT calculation for quantity 1 is incorrect");
}

@Test
public void testCalculateItemVATLargerQuantity() {
    double expectedVAT = itemLargerQuantity.getItemInformation().getVATRate() * itemLargerQuantity.getItemValue() * 3;
    double result = itemLargerQuantity.calculateItemVAT();
    assertEquals(expectedVAT, result, 0.001, "VAT calculation for quantity 3 is incorrect");
}

@Test
public void testUpdateQuantityAddItem() {
    itemDefaultQuantity.updateQuantity(2); 
    assertEquals(3, itemDefaultQuantity.getItemQuantity(), "Quantity should be updated to 3 after adding 2");
}

@Test
public void testUpdateQuantityRemoveItem() {
    itemLargerQuantity.updateQuantity(-1); 
    assertEquals(2, itemLargerQuantity.getItemQuantity(), "Quantity should be decreased to 2 after removing 1");
}

@Test
public void testUpdateQuantityInvalidQuantity() {
    itemDefaultQuantity.updateQuantity(-1); 
    assertEquals(1, itemDefaultQuantity.getItemQuantity(), "Quantity should remain 1 when trying to reduce below zero");
}

@Test 
public void testGetItemDTO() {
    ItemDTO result = itemDefaultQuantity.getItemDTO();
    assertTrue(result instanceof ItemDTO, "Method should return an instance of ItemDTO");
}
}
