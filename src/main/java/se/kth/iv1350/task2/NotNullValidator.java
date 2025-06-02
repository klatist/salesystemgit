package se.kth.iv1350.task2;

/**
 * This class is an implementation of the <code>Validator</code> interface that limits the values of
 * objects to be invalid if null.
 */
public class NotNullValidator<T> implements Validator<T>{

    /**
     * This method checks if the value of the object is valid.
     * 
     * @param obj  represents the object whose value will be checked for validity.
     * @return  true if the object value is valid or false if does not meet the condition.
     */
    @Override
    public boolean isValid(T obj){
        return obj != null;
    }

    /**
     * This method gives access to the error message that is applicable if the object is not valid.
     * 
     * @return a string with the error message.
     */
    @Override
    public String getErrorMessage(){
        return "Object cannot be null";
    }
    
}
