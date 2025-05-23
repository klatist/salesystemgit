package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;
import java.lang.Exception;

/**
 * This is the template class that sets the frame for printing or logging total revenue. It implements the
 * RevenueObserver interface.
 */
public abstract class RevenueTemplate implements RevenueObserver{
    private AmountDTO totalRevenue = new AmountDTO();
    
    /**
     * Implements the updateTotalRevenue from RevenvueObserver.
     * Calculates the total revenue and print it..2f
     * @param saleRevenue the reevenue from the completed sale.
     */
    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        calculateTotalRevenue(saleRevenue);
        printTotalRevenue();
    }

    /**
     * Calculates the new total revenue by adding the lateet revenue to the total revenue. 
     * @param saleRevenue
     */
    private void calculateTotalRevenue(AmountDTO saleRevenue)
    {
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
    }

    /**
     * Prints the total revenue by calling abstract classes 
     */
    private void printTotalRevenue(){
        try
        {
            doPrintTotalRevenue(totalRevenue);
        }
        catch(Exception exc)
        {
            handleErrors(exc);
        }
    
    }
        
    protected abstract void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception;

    protected abstract void handleErrors(Exception exc);

}

