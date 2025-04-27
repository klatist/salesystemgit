package se.kth.iv1350.salesystem.model;

import se.kth.iv1350.salesystem.integration.Printer;
/**
 * This class represent the payment procedure of the sale and also calls methods to print the receipt.
 */
public class CashPayment {
    private Sale sale;
    private Amount paidAmount;
    private Amount change;

    /**
     * Creates a payment instance. 
     * @param sale Holds all information about the sale.
     * @param paidAmount Represent the customers payment.
     */
    public CashPayment(Sale sale, Amount paidAmount){
        this.sale = sale;
        this.paidAmount = paidAmount;
        this.change = calculateChange();
    }

    public Sale getSale(){
        return sale;
    }

    public Amount getPaidAmount(){
        return paidAmount;
    }

    public Amount getChange(){
        return change;
    }
    /**
     * Calculates the change based on the ampunt paid and the total price of the sale. 
     * @return the <code>Amount</code> change 
     */
    private Amount calculateChange(){
        return new Amount(this.sale.getTotalPriceAmount()-this.paidAmount.getAmount());
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
