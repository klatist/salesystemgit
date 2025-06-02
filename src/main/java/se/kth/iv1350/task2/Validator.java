package se.kth.iv1350.task2;
/**
 * This interface represents the <code>Validator</code> that will decide the conditions of validity of
 * values of objects.
 */
public interface Validator<T> {
    boolean isValid(T value);
    String getErrorMessage();
    
}
