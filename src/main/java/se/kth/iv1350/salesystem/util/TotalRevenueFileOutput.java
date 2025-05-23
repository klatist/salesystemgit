package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.view.ErrorMessageHandler;

/**
 * This class is an implementation of the <code>RevenueObserver</code> interface that handles
 * the logging of the total revenue by calculating the new <code>totalRevenue</code> and then calling
 * the <code>RevenueLogger</code> to log after updating the <code>totalRevenue</code>.
 */
public class TotalRevenueFileOutput extends RevenueTemplate{
    private RevenueLogger logger;

    /**
     * Creates an instance of <code>TotalFileOutput</code> by creating <code>totalRevenue</code>
     * and the <code>logger</code>.
     */
    public TotalRevenueFileOutput(){
        logger = new RevenueLogger();
    }


    /**
     * Updates the <code>totalRevenue</code> with the revenue from the most recent <code>sale</code> added
     * and then logs the new <code>totalRevenue</code> to a file.
     * 
     * @param saleRevenue  represents the revenue from the most recent <code>sale</code>.
     */
    @Override
    protected void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception{
        
        logger.logRevenue(totalRevenue);

    }

    @Override
    protected void handleErrors(Exception exc){
        ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("The total revenue could not be logged to the file.");
        ExceptionLogger.getExceptionLogger().logException(exc);
    }

        
}
