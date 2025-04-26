package se.kth.iv1350.salesystem.model;

import se.kth.iv1350.salesystem.integration.Printer;

public class CashPayment {
    private Sale sale;
    private Amount paidAmount;
    private Amount change;

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

    private Amount calculateChange(){
        return new Amount(this.sale.getTotalPriceAmount()-this.paidAmount.getAmount());
    }

    public void printReceipt(Printer printer){
        ReceiptDTO receipt = new ReceiptDTO(this);

        printer.printReceipt(receipt);
    }

}
