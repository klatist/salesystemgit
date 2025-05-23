package se.kth.iv1350.task2;

import java.lang.Math;

public class IntegerValidator implements Validator<Integer>
{
    private int maxDigits;

    public IntegerValidator(int maxDigits)
    {
        this.maxDigits = maxDigits;
    }

    @Override
    public boolean isValid(Integer value)
    {
        if(value == null)
            return false;

        int numDigits = String.valueOf(Math.abs(value)).length();

        return numDigits <= maxDigits;
    }

    @Override
    public String getErrorMessage()
    {
        return "Integer must have at most " + maxDigits + "digits.";
    }
    
}
