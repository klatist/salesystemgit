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
     * Calculates the total revenue and print it by calling the subclasses methods. 
     * @param saleRevenue the revenue from the completed sale.
     */
    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        calculateTotalRevenue(saleRevenue);
        printTotalRevenue();
    }

    /**
     * Calculates the new total revenue by adding the lateet revenue to the total revenue. 
     * @param saleRevenue the revenue from the completed sale.
     */
    private void calculateTotalRevenue(AmountDTO saleRevenue)
    {
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
    }

    /**
     * Prints the total revenue by calling abstract classes doPrintTotalReveneu and the handleErors
     * which is the observsers implementations of the abstract methods. 
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

    /**
    * Defines the method that prints the total revenue. Must be implemented by the observer subclasses.
    * @param totalRevenue the total revenue since the program started. 
    */   
    protected abstract void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception;
    
    /**
    * Defines the method that handles errors. Must be implemented by the observer subclasses.
    * @param exc the thrown exception
    */ 
    protected abstract void handleErrors(Exception exc);

}

