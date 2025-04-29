package se.kth.iv1350.salesystem.model;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashPaymentTest {
    CashPayment payment;
    Sale sale;
    AmountDTO paidAmount;

    @BeforeEach
    public void setup(){
        ItemInformationDTO yoghurt = new ItemInformationDTO("Naturell Yoghurt", new AmountDTO(25.95), 222222, 0.12, "Arla naturell yoghurt. Fetthalt 3%. 1000 gram.");
        ItemInformationDTO baguette = new ItemInformationDTO("Baguette", new AmountDTO(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram");
        
        sale = new Sale(); 

        sale.addToCart(2, yoghurt);
        sale.addToCart(1, baguette);

        paidAmount = new AmountDTO(200);
    }

    @AfterEach
    public void tearDown()
    {
        sale = null;
        paidAmount = null;
    }


    @Test
    public void testConstructorIntAmount()
    {
        CashPayment constructPayment = new CashPayment(sale, paidAmount);
        assertEquals(paidAmount.getValue(), constructPayment.getPaidAmount().getValue(), "the paid amounts should be equal if the object is initiated correcly");
    }

    @Test
    public void testConstructorDoubleAmount()
    {   AmountDTO paidAmountDouble = new AmountDTO(200.50);
        CashPayment constructPayment = new CashPayment(sale, paidAmountDouble);
        assertEquals(paidAmountDouble.getValue(), constructPayment.getPaidAmount().getValue(), "the paid amounts should be equal if the object is initiated correcly");
    }

    @Test
    public void testCalculateChangeInt()
    {
        CashPayment calcChangePaymentInt = new CashPayment(sale, paidAmount);
        double result = calcChangePaymentInt.getChange().getValue();
        double expChange = paidAmount.getValue()-sale.getTotalPriceValue();
        assertEquals(expChange, result, "The expected change should match the result");
    }

    @Test
    public void testCalculateChangeDouble(){
        AmountDTO paidAmountInt = new AmountDTO(200.50);
        CashPayment calcChangePaymentDouble = new CashPayment(sale, paidAmountInt);
        double result = calcChangePaymentDouble.getChange().getValue();
        double expChange = paidAmountInt.getValue()-sale.getTotalPriceValue();
        assertEquals(expChange, result, "The expected change should be the same as the result");
    }

}

