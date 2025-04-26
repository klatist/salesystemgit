package se.kth.iv1350.salesystem.model;

import java.util.Currency;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmountTest {
    
    private Amount amountAdd; 
    private Amount amountMultiply;

    @BeforeEach 
    public void setUp(){
        amountAdd = new Amount();
        amountMultiply = new Amount(1);

    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    public void testDefaultConstructor(){
        Amount amount = new Amount();
        Currency expCurrency = Currency.getInstance("SEK");
        assertEquals(expCurrency, amount.getCurrency(),"The currency should be SEK");;
        assertEquals(0, amount.getAmount(),"the amount does not match");
    }

    @Test
    public void testDefaultCurrencyConstructor(){
        Amount amount = new Amount(10);
        Currency expCurrency = Currency.getInstance("SEK");
        assertEquals(expCurrency, amount.getCurrency(),"The currency should be SEK");;
        assertEquals(10, amount.getAmount(), "the amount does not match");
    }

    @Test
    public void testConstructor(){
        Currency currency = Currency.getInstance("USD");
        Amount amount = new Amount(currency, 10);
        assertEquals(currency, amount.getCurrency(),"The currency should be USD");
        assertEquals(10, amount.getAmount(), "the amount does not match");
    }

    @Test 
    public void testAddPositiveAmount(){
        Amount toBeAdded = new Amount(2);
        amountAdd.addAmount(toBeAdded);
        assertEquals(2, amountAdd.getAmount(), "expected value after adding is 2");

    }

    @Test 
    public void testAddNegativeAmount(){
        Amount toBeAdded = new Amount(-2);
        amountAdd.addAmount(toBeAdded);
        assertEquals(-2, amountAdd.getAmount(), "expectd value after adding is -2");

    }

    @Test 
    public void testAddNullObject(){
        Amount toBeAdded = null;
        amountAdd.addAmount(toBeAdded);
        assertEquals(0, amountAdd.getAmount(), "the value should not change");
    }
    

    @Test 
    public void testMultiplyPositiveAmount(){
        double toBeMultiplied = 2;
        double result = amountMultiply.multiply(toBeMultiplied).getAmount();
        assertEquals(2, result, "expected value after adding is 2");

    }

    @Test 
    public void testMultiplyNegativeAmount(){
        double toBeMultiplied = -2;
        double result = amountMultiply.multiply(toBeMultiplied).getAmount();
        assertEquals(-2, result, "expectd value after adding is -2");

    }
}


