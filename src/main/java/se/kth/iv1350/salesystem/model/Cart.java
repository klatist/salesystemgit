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

    public List<Item> getCartList(){
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

    
}