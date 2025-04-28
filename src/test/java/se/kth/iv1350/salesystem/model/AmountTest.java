package se.kth.iv1350.salesystem.model;

import java.util.Currency;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmountTest {
    

    @BeforeEach 
    public void setUp(){

    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    public void testDefaultConstructor(){
        Amount amount = new Amount();
        Currency expCurrency = Currency.getInstance("SEK");
        assertEquals(expCurrency, amount.getCurrency(),"The currency should be SEK");;
        assertEquals(0, amount.getValue(),"the amount does not match");
    }

    @Test
    public void testDefaultCurrencyConstructor(){
        Amount amount = new Amount(10);
        Currency expCurrency = Currency.getInstance("SEK");
        assertEquals(expCurrency, amount.getCurrency(),"The currency should be SEK");;
        assertEquals(10, amount.getValue(), "the amount does not match");
    }

    @Test
    public void testConstructor(){
        Currency currency = Currency.getInstance("USD");
        Amount amount = new Amount(currency, 10);
        assertEquals(currency, amount.getCurrency(),"The currency should be USD");
        assertEquals(10, amount.getValue(), "the amount does not match");
    }
}