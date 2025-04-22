package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.Item;
import se.kth.iv1350.salesystem.model.ItemInformationDTO;
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
        for(Item item : inventory)
        {
            if (item.getItemInformation().getItemID() == itemID)
            {
                return item;
            }
        }

        return null;
    }

    /**
     * This method...
     * @param itemID
     * @return
     */
    public ItemInformationDTO fetchItemInformation(int itemID){
        Item item = findInInventory(itemID);

        if(item != null){
            return item.getItemInformation();

        }
        else
            return null;
    }


    private void addItems(){

    }
    
}
