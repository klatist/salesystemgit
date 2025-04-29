package se.kth.iv1350.salesystem.model;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTest {
    private Register registerZero; 
    private Register registerWithMoney; 

    @BeforeEach
    public void setUp(){
        registerZero = new Register(0.0);
        registerWithMoney = new Register(100);
    }

    @AfterEach
    public void tearDown(){
        registerZero = null;
        registerWithMoney = null;
    }

    @Test
    public void testConstructorZero(){
        Register register = new Register(0);
        double result = register.getBalance().getValue();
        assertEquals(0, result, "The amount should be 0 if the object was initiated correctly");
    
    }

    @Test 
    public void testConstructorMoney(){
        Register register = new Register(100);
        double result = register.getBalance().getValue();
        assertEquals(100, result, "The amount should be 100 if the object was initiated correctly");
    
    }


    @Test
    public void testUpdateZeroBalanceWithMoney() {
        AmountDTO runningTotal = new AmountDTO(200.0);
        registerZero.updateBalance(runningTotal);
        assertEquals(200, registerZero.getBalance().getValue(),"the balance should be updated with the correct amount");
    }

    @Test
    public void testUpdateZeroBalanceWithZero() {
        AmountDTO runningTotal = new AmountDTO(0.0);
        registerZero.updateBalance(runningTotal);
        assertEquals(0, registerZero.getBalance().getValue(),"the balance should be updated with the correct amount");
    }

    @Test
    public void testUpdateMoneyBalanceWithMoney() {
        AmountDTO runningTotal = new AmountDTO(100.0);
        registerWithMoney.updateBalance(runningTotal);
        assertEquals(200, registerWithMoney.getBalance().getValue(),"the balance should be updated with the correct amount");
    }

    @Test
    public void testUpdateMoneyBalanceWitthZero() {
        AmountDTO runningTotal = new AmountDTO(0.0);
        registerWithMoney.updateBalance(runningTotal);
        assertEquals(100, registerWithMoney.getBalance().getValue(),"the balance should be updated with the correct amount");
    }
}
