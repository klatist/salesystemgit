package se.kth.iv1350.salesystem.integration;

/**
 * Thrown when trying to scan an item with an itemID that does not exist in inventory.
 */
public class ItemIdentifierException extends Exception {
    private int invalidItemIdentifier;


/**
 * Throws exception when searching for an itemID which does not exist in the inventory. 
 * @param invalidItemItentifier the ID of the item that odes not exist. 
 */
    public ItemIdentifierException(int invalidItemIdentifier){
        super("Can not scan item with itemID " + invalidItemIdentifier + 
                ", because it does not exist in inventory");
        
        this.invalidItemIdentifier = invalidItemIdentifier;
    }


    public int getInvalidItemIdentifier(){
        return invalidItemIdentifier;
    }
    
}
