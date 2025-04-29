package se.kth.iv1350.salesystem.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> cart;


    public Cart(){
        this.cart = new ArrayList<Item>();
    }

    public void add(Item item){
        this.cart.add(item);

    }

    public Item getItem(int position){
        return this.cart.get(position);
    
    }

    public List<Item> getCart(){
        return this.cart;
    }

    public List<ItemDTO> toItemDTOCart(){
        List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
        for (Item item : cart){
            itemDTOs.add(item.getItemDTO());
        }
        return itemDTOs;
    }

    /**
     * Search for an already existing item in cart
     * 
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