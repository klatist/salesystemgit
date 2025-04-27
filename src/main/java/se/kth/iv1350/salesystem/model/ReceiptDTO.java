package se.kth.iv1350.salesystem.model;

import java.time.LocalDateTime;
import java.util.List;
/**
 * This class hold all the information used to print the receipt
 */
public class ReceiptDTO {
    private LocalDateTime dateTime;
    private List<Item> cart;
    private Amount totalPrice;
    private double totalVAT;
    private Amount paidAmount;
    private Amount change;

    /**
     * Creates a <code>ReceiptDTO</code> containing all necessary information for generating a receipt, based on a completed payment.
     * @param payment The <code>CashPayment</code> containing all relevant information about the sale and the payment.
     */
    public ReceiptDTO(CashPayment payment){
        this.dateTime = payment.getSale().getDateTime();
        this.cart = payment.getSale().getCart();
        this.totalPrice = payment.getSale().getTotalPrice();
        this.totalVAT = payment.getSale().getTotalVAT();
        this.paidAmount = payment.getPaidAmount();
        this.change = payment.getChange();
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public List<Item> getCart(){
        return cart;
    }

    public Amount getTotalPrice(){
        return totalPrice;
    }

    public double getTotalPriceAmount(){
        return totalPrice.getAmount();
    }

    public double getTotalVAT(){
        return totalVAT;
    }

    public Amount getPaidAmount(){
        return paidAmount;
    }

    public Amount getChange(){
        return change;
    }
    
}
