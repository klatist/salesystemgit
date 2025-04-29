package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;
/**
 * This class handles the cart which holds the customers items.
 */
public class Cart {
    private List<Item> cart;

    /**
     * Creates the cart as an ArrayAist.
     */
    public Cart(){
        this.cart = new ArrayList<>();
    }
    
    /**
     * Adds an item to the last position in the list. 
     * @param item The item to be added
     */
    public void add(Item item){
        this.cart.add(item);

    }

    public Item getItem(int position){
        return this.cart.get(position);
    
    }

    public List<Item> getCart(){
        return this.cart;
    }

    /**
     * Converts the items in the <code>cart</code> to the type <code>ItemDTO</code>.
     * @return List <code>ItemDTOs</code>.
     */
    public List<ItemDTO> toItemDTOCart(){
        List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
        for (Item item : cart){
            itemDTOs.add(item.getItemDTO());
        }
        return itemDTOs;
    }

    /**
     * Search for an already existing item in cart
     * @param scannedItemID Represents the item id the cashier recently scanned
     * @return return the item <code>position</code> in <code>cart</code> if found, 
     *         if not found -1 is returned.
     */
    public int findInCart(int scannedItemID){
        int position = -1;

        for(int i = 0; i < cart.size(); i++){
            int existingItemID = cart.get(i).getItemID();

            if(scannedItemID == existingItemID)
            {
                position = i;
                return position;
            }
        }

        return position;
    }
}