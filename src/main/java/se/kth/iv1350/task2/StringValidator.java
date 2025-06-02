package se.kth.iv1350.task2;

/**
 * This class is an implementation of the <code>Validator</code> interface that limits the length
 * a String object can have.
 */
public class StringValidator implements Validator<String>{
    private int maxLength;

    /**
     * This constructor creates an instance of the <code>StringValidator</code> class and decides
     * the maximum length the String can have.
     * @param maxLength
     */
    public StringValidator(int maxLength){
        this.maxLength = maxLength;
    }


    /**
     * This method checks if the value of the String object is valid.
     * 
     * @param value  represents the String object whose value will be checked for validity.
     * @return  true if the String value is valid or false if it does not meet the conditions.
     */
    @Override
    public boolean isValid(String value){
        if(value == null)
            return false;

        return value.length() <= maxLength;
    }

    /**
     * This method gives access to the applicable error message if the String object is not valid.
     * 
     * @return a string with the error message.
     */
    @Override
    public String getErrorMessage(){
        return "String cannot be null and string length cannot longer than " + maxLength + " characters.";
    }
    
}
