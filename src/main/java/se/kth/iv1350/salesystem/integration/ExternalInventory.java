package se.kth.iv1350.salesystem.integration;

import se.kth.iv1350.salesystem.model.ItemInformationDTO;
import se.kth.iv1350.salesystem.model.Item;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represent an inventory system.
 * It holds information about all items available in the store and is updated 
 * with sale information after a completed sale.
 */
public class ExternalInventory {
    private List<Item> inventory;

    public ExternalInventory(){
        inventory = new ArrayList();
    }

    public Item findInInventory(int itemID){
        
    }

    /**
     * This method...
     * @param itemID
     * @return
     */
    public ItemInformationDTO fetchItemInformation(int itemID){
        


    }


    private void addItems(){

    }
    
}
