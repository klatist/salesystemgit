package se.kth.iv1350.salesystem.model; 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Sale {
    private LocalDateTime dateTime;
    private Amount totalPrice;
    private Amount totalVAT;
    private List<Item> cart;
    

    // Konstruktor som automatiskt sätter aktuellt datum och tid
    public Sale() {
        this.dateTime = LocalDateTime.now();  // Sätter aktuellt datum och tid vid skapandet
        this.totalPrice = new Amount();
        this.totalVAT = new Amount();
        this.cart = new ArrayList<>();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Amount getTotalPrice(){
        return totalPrice;
    }

    public Amount getTotalVAT(){
        return totalVAT;
    }

    public List<Item> getCart(){
        return cart;
    }

    private int getItemIDFromCart(int positionInCart){

        return cart.get(positionInCart).getItemInformation().getItemID();

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
}

