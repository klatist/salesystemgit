package se.kth.iv1350.salesystem.controller;
/**
 * Thrown as a middle-hand exception to represent a failure that occurred due to another
 * exception. This class therefore acts as a wrapper for lower-level exceptions to be 
 * handled at a higher level.
 */

public class OperationFailedException extends Exception {

    /**
     * Constructor that creates a new instance of <code>OperationFailedException</code>.
     * 
     * @param cause represents the original exception which is the cause for an exception being
     * thrown in the first place. It can later be retrieved by using the <code>getCause()</code> method.
     */
    public OperationFailedException(Exception cause){
        super(cause);
    }
    
}
