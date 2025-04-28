package se.kth.iv1350.salesystem.model;

import java.time.LocalDateTime;
import java.util.List;
/**
 * This class hold all the information used to print the receipt
 */
public class ReceiptDTO {
    private LocalDateTime dateTime;
    private List<Item> cart;
    private Amount finalTotalPrice;
    private double finalTotalVAT;
    private Amount paidAmount;
    private Amount change;

    /**
     * Creates a <code>ReceiptDTO</code> containing all necessary information for generating a receipt, based on a completed payment.
     * @param payment The <code>CashPayment</code> containing all relevant information about the sale and the payment.
     */
    public ReceiptDTO(CashPayment payment){
        this.dateTime = payment.getSale().getDateTime();
        this.cart = payment.getSale().getCart();
        this.finalTotalPrice = payment.getSale().getTotalPrice();
        this.finalTotalVAT = payment.getSale().getTotalVAT();
        this.paidAmount = payment.getPaidAmount();
        this.change = payment.getChange();
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public List<Item> getCart(){
        return cart;
    }

    public Amount getFinalTotalPrice(){
        return finalTotalPrice;
    }

    public double getFinalTotalPriceValue(){
        return finalTotalPrice.getValue();
    }

    public double getFinalTotalVAT(){
        return finalTotalVAT;
    }

    public Amount getPaidAmount(){
        return paidAmount;
    }

    public Amount g