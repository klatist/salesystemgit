package se.kth.iv1350.salesystem.integration;

/**
 * Thrown when the database can not be called.
 */
public class DatabaseFailureException extends RuntimeException {

    /**
     * Constructor that creates an instance of <code>DatabaseFailureException</code> with the 
     * specified message. Is thrown when database is not available. 
     * 
     * @param message a message to indicate the issue. It can later be retrieved with the method
     * <code>getMessage()</code>.
     */
    public DatabaseFailureException(String message){
        super(message);
    }
    
}
