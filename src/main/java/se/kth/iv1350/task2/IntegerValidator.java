package se.kth.iv1350.task2;

import java.lang.Math;

/**
 * This class represents an implementation of the <code>Validator</code> interface that limits the
 * amount of digits the value can have.
 */
public class IntegerValidator implements Validator<Integer>
{
    private int maxDigits;

    /**
     * This constructor creates an instance of the <code>IntegerValidator</code> class and decides the
     * maximum amount of digits.
     * @param maxDigits
     */
    public IntegerValidator(int maxDigits)
    {
        this.maxDigits = maxDigits;
    }

    /**
     * This method checks if the value of the object is valid.
     * 
     * @param value  represents the object whose value will be checked for validity.
     * @return  true if the object value is valid or false if it does not meet the conditions.
     */
    @Override
    public boolean isValid(Integer value)
    {
        if(value == null)
            return false;

        int numDigits = String.valueOf(Math.abs(value)).length();

        return numDigits <= maxDigits;
    }

    /**
     * This method gives access to the error message that is applicable if the object is not valid.
     * @return a string with the error message.
     */
    @Override
    public String getErrorMessage()
    {
        return "Integer cannot have more than " + maxDigits + " digits and if object, it cannot be null.";
    }
    
}
