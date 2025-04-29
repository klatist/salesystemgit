package se.kth.iv1350.salesystem.model;

import se.kth.iv1350.salesystem.integration.Printer;
/**
 * This class represent the payment procedure of the sale and also calls methods to print the receipt.
 */
public class CashPayment {
    private Sale sale;
    private AmountDTO paidAmount;
    private AmountDTO change;

    /**
     * Creates a payment instance. 
     * @param sale Holds all information about the sale.
     * @param paidAmount Represent the customers payment.
     */
    public CashPayment(Sale sale, AmountDTO paidAmount){
        this.sale = sale;
        this.paidAmount = paidAmount;
        this.change = calculateChange();
    }

    public Sale getSale(){
        return sale;
    }

    public AmountDTO getPaidAmount(){
        return paidAmount;
    }

    public AmountDTO getChange(){
        return change;
    }
    /**
     * Calculates the change based on the ampunt paid and the total price of the sale. 
     * @return the <code>AmountDTO</code> change 
     */
    private AmountDTO calculateChange(){
        return new AmountDTO(this.paidAmount.getValue() - this.sale.getTotalPriceValue());
    }

    /**
     * Creates a <code>ReceiptDTO</code> representing the completed sale
     * and sends it to the specified <code>Printer</code> for printing.
     * @param printer the printer object.
     */
    public void printReceipt(Printer printer){
        ReceiptDTO receipt = new ReceiptDTO(this);

        printer.printReceipt(receipt);
    }

}
