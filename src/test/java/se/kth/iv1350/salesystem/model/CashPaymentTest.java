package se.kth.iv1350.salesystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashPaymentTest {
    CashPayment payment;
    Sale sale;
    Amount paidAmount;

    @BeforeEach
    public void setup(){
        ItemInformationDTO yoghurt = new ItemInformationDTO("Naturell Yoghurt", new Amount(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram."));
        Item baguette = new Item(new ItemInformationDTO("Baguette", new Amount(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"));
        
        sale = new Sale(); 

        sale.addToCart(2, yoghurt);
        sale.addToCart(0, null);
    }

    

    @Test
    public void testConstructor()
    {
        CashPayment constructPayment = new CashPayment(sale, paidAmount);
        assertEquals(paidAmount.getValue(), constructPayment.getPaidAmount().getValue(), "the paid amounts should be equal if the object is initiated correcly")
    }
}
