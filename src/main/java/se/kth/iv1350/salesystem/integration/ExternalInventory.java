package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.Amount;
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
        addItem();
    }

    private void addItem(){
        inventory.add(new ItemInformationDTO("Baguette", new Amount(15.50), 123456, 0.12, "god baguette kom och köp"));
        inventory.add(new ItemInformationDTO("Kalaspuffar",new Amount(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor"));
        inventory.add(new ItemInformationDTO("Jordnötsmör", new Amount(23.50), 111111, 0.12, "Skippy smooth ;)"));
    }
    
    /**
     * This method...
     * @param itemID
     * @return
     */
    public ItemInformationDTO fetchItemInformation(int itemID){
        for(ItemInformationDTO item : inventory)
        {
            if (item.getItemID() == itemID)
            {
                return item;
            }
        }
        return null;
    }
}
