package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.util.ExceptionLogger;
import se.kth.iv1350.salesystem.util.RevenueTemplate;

/**
 * This class is an implementation of the <code>RevenueObserver</code> that displays the
 * <code>totalRevenue</code> to the <code>view</code>.
 */
public class TotalRevenueView extends RevenueTemplate{

    /**
     * Prints the <code>totalRevenue</code> to a suitable format for the view.
     * @param totalRevenue  represents the most recently calculated total revenue.
     */
    @Override
    protected void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception{
        System.out.printf("\n Total Revenue: %.2f %s\n", 
            totalRevenue.getValue(),
            totalRevenue.getCurrency().toString());
    }
    
    /**
     * Handles the exception that was thrown by showing a suitable message for the user and logging the exception
     * to the exception log file for the developers.
     * 
     * @param exc  Represents the exception that was thrown during execution of the
     *  <code>coPrintTotalRevenue</code> method.
     */
    @Override
    protected void handleErrors(Exception exc){
        ErrorMessageHandler.getErrorMessageHandler().showErrorMessage
            ("The total revenue could not be shown at the moment.");
        ExceptionLogger.getExceptionLogger().logException(exc);
    }
}
