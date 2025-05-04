package se.kth.iv1350.salesystem.model; 
import java.time.LocalDateTime;
/**
* This class represents and handles the ongoing sale 
*/

public class Sale {
    private LocalDateTime dateTime;
    private AmountDTO totalPrice;
    private double totalVAT;
    private Cart cart;
    

   /**
     * Creates a new <code>Sale</code> instance with the current date and time,
     * an empty shopping cart, and total price and VAT set to zero.
     */
    public Sale() {
        this.dateTime = LocalDateTime.now();  
        this.totalPrice = new AmountDTO();
        this.totalVAT = 0.0;
        this.cart = new Cart();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getTotalVAT(){
        return totalVAT;
    }

    public AmountDTO getTotalPrice(){
        return totalPrice;
    }

    public double getTotalPriceValue(){
        return totalPrice.getValue();
    }

    public Cart getCart(){
        return cart;
    }

    public SaleDTO getSaleInformation(){
        SaleDTO saleInformation = new SaleDTO(this);

        return saleInformation;

    }
    

    /**
     * Updates the runnning total price exc VAT and the total VAT for the sale. 
     */
    public void updateTotalPriceAndVAT(){
        double totalPriceExcVAT = 0.0;
        double calculatedVAT = 0.0;

        for(Item cartItem : cart.getCart())
        {
            totalPriceExcVAT += cartItem.calculateItemPrice();
            calculatedVAT += cartItem.calculateItemVAT();
        }   
        this.totalVAT = calculatedVAT;
        this.totalPrice = new AmountDTO(totalPriceExcVAT + totalVAT);

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
        int cartSize = cart.getCart().size()-1;
        Item currentItem = cart.getItem(position);

        if (position <= cartSize || position >= 0){
            currentItem.updateQuantity(itemQuantity);
            updateTotalPriceAndVAT();
        }
    }   
    


}

    


