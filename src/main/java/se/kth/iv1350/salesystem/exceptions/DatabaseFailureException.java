package se.kth.iv1350.salesystem.exceptions;

/**
 * Thrown when the database can not be called.
 */
public class DatabaseFailureException extends Exception {

    public DatabaseFailureException(String message){
        super(message);
    }
    
}
