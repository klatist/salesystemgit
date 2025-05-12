package se.kth.iv1350.salesystem.exceptions;

/**
 * Thrown when trying to scan an item with an itemID that does not exist in inventory.
 */
public class ItemIdentifierException extends Exception {
    private int invalidItemIdentifier;

    public ItemIdentifierException(int invalidItemIdentifier){
        super("Can not scan item with itemID " + invalidItemIdentifier + 
                ", because it does not exist in inventory");
        
        this.invalidItemIdentifier = invalidItemIdentifier;
    }

    public int getInvalidItemIdentifier(){
        return invalidItemIdentifier;
    }
    
}
