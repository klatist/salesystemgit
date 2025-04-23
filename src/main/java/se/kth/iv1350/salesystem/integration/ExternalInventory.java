package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.ItemInformationDTO;
/**
 * This class represent an inventory system.
 * It holds information about all items available in the store and is updated 
 * with sale information after a completed sale.
 */
public class ExternalInventory {
    private List<ItemInformationDTO> inventory;

    public ExternalInventory(){
        inventory = new ArrayList();
    }

    private ItemInformationDTO findInInventory(int itemID){
        for(ItemInformationDTO item : inventory)
        {
            if (item.getItemID() == itemID)
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
        //ItemInformationDTO item = findInInventory(itemID);

        return findInInventory(itemID);

        /*if(item != null){
            return item;
        }
        else
            return null;*/
    }


    private void addItems(){

    }
    
}
