package se.kth.iv1350.task2;

/**
 * This factory class is responsible for selecting and returning the right <code>Validator</code> object
 * depending on the class.
 */
public class ValidatorFactory {
    /**
     * Selects a suitable <code>Validator</code> class based on which type of class that is sent in as
     * argument and creates and returns an instance of the selected <code>Validator</code>.
     * @param <T>
     * @param valClass
     * @param maxConstraint  represents the maximum constraint if there is one, for example a max length 
     * of a <code>String</code> or max amount of digits of an integer.
     * @return an object of the selected <code>Validator</code> type.
     */
    @SuppressWarnings("unchecked")
    public static <T> Validator<T> getValidator(Class<T> valClass, Integer maxConstraint){
        if(valClass == String.class)
        {
            return (Validator<T>) new StringValidator(maxConstraint);
        }
        else if(valClass == Integer.class)
        {
            return (Validator<T>) new IntegerValidator(maxConstraint);
        }
        else
            return new NotNullValidator<>();
    }
    
}
