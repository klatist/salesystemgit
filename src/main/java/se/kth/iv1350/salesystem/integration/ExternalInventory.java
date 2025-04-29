package se.kth.iv1350.salesystem.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.ItemInformationDTO;
import se.kth.iv1350.salesystem.model.SaleDTO;
/**
 * This class represent an inventory system.
 * It holds information about all items available in the store and is updated with sale information after a completed sale.
 */
public class ExternalInventory {

    private List<ItemInformationDTO> inventory;
    /**
     * Sets up the store inventory with chosen items. 
     */
    public ExternalInventory(){
        inventory = new ArrayList<>();
        addItem();
    }
    /**
     * Adds multiple <code>ItemInformationDTO</code> to represent the items in the store inventory.
     */
    private void addItem(){
        inventory.add(new ItemInformationDTO("Baguette", new AmountDTO(15.50), 123456, 0.12, "Ljus baguette bakad på vetemjöl, vatten, salt och jäst. Traditionellt franskt recept. Vikt ca 250 gram"));
        inventory.add(new ItemInformationDTO("Kalaspuffar",new AmountDTO(40.95) , 654321, 0.12, "Gör din frukost till en fest med våra flingor. Vikt 500 gram"));
        inventory.add(new ItemInformationDTO("Jordnötsmör", new AmountDTO(23.50), 111111, 0.12, "Skippy smooth. Vikt 300 gram"));
    }
    
    /**
     * Searches the inventory for an item based on the given itemID.
     * @param itemID the identifier for the item. 
     * @return if the itemID match an item in the inventory the <code>ItemInformationDTO</code> is returned. If there is no match <code>null</code> is returned
     */
    public ItemInformationDTO fetchItemInformation(int itemID){
        for(ItemInformationDTO itemInformation : inventory)
        {
            if (itemInformation.getID() == itemID)
            {
                return itemInformation;
            }
        }
        return null;
    }

    /**
     * Updates the store's inventory system with the information from a completed sale.
     *
     * @param finalSaleInformation Information about the completed sale.
     */
    public void updateInventory(SaleDTO finalSaleInformation){

    }
}
