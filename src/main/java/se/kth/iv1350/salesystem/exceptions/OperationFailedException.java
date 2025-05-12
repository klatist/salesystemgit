package se.kth.iv1350.salesystem.exceptions;

public class OperationFailedException extends Exception {
    public OperationFailedException(String message, Exception cause){
        super(message, cause);
    }
    
}
