package se.kth.iv1350.salesystem.model; 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Sale {
    private LocalDateTime dateTime;
    private Amount totalPrice;
    private double totalVAT;
    private List<Item> cart;
    

    /**
     * Constructor that creates a Sale object.
     */
    public Sale() {
        this.dateTime = LocalDateTime.now();  
        this.totalPrice = new Amount();
        this.totalVAT = 0.0;
        this.cart = new ArrayList<>();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Amount getTotalPrice(){
        return totalPrice;
    }

    public double getTotalVAT(){
        return totalVAT;
    }

    public List<Item> getCart(){
        return cart;
    }


    private int getItemIDFromCart(int positionInCart){

        return cart.get(positionInCart).getItemInformation().getItemID();

    }

    public SaleDTO getSaleInformation(){
        SaleDTO saleInformation = new SaleDTO(this);

        return saleInformation;

    }


    /**
     * Updates the total price and the total VAT for all the items in the cart.
     */
    public void updateTotalPriceAndVAT(){

        for(Item cartItem : cart)
        {
            this.totalPrice.add(cartItem.calculateItemPrice());
            this.totalVAT += cartItem.calculateItemVAT();
        }   

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
            int existingItemID = getItemIDFromCart(i);
            if(scannedItemID == existingItemID)
            {
                position = i;
                return position;
            }
        }

        return position;
    }


    /**
     * Updates the cart by creating an item, adding the item to the cart and calculating the new total
     * price and VAT.
     * 
     * @param itemQuantity Represents the quantity of the item that has been scanned.
     * @param itemInformation Represents the information about the item that has been 
     *        fetched from the external inventory system.
     */
    public void addToCart(int itemQuantity, ItemInformationDTO itemInformation){
        if(itemQuantity >=1 ){
            Item scannedItem = new Item(itemQuantity, itemInformation);
            cart.add(scannedItem);
            updateTotalPriceAndVAT();
        }

    }

    /**
     * Updates the quantity of the item in the cart and calculates the new total price and VAT.
     * 
     * @param position Represents the position where the item already exists in the cart.
     * @param itemQuantity Represents the quantity of the item to be added to the cart.
     */
    public void updateQuantityInCart(int position, int itemQuantity){
        if (position > cart.size()-1 || position < 0){
            cart.get(position).updateQuantity(itemQuantity);
            updateTotalPriceAndVAT();
        }
    }   
    


}

    


