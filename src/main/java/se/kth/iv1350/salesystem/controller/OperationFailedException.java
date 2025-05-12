package se.kth.iv1350.salesystem.controller;

public class OperationFailedException extends Exception {
    public OperationFailedException(Exception cause){
        super(cause);
    }
    
}
