package se.kth.iv1350.task2;
/**
 * This interface represents 
 */
public interface Validator<T> {
    boolean isValid(T value);
    String getErrorMessage();
    
}
