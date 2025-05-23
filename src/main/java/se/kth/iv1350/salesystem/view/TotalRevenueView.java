package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.util.ExceptionLogger;
import se.kth.iv1350.salesystem.util.RevenueTemplate;

/**
 * This class is an implementation of the <code>RevenueObserver</code> that displays the
 * <code>totalRevenue</code> to the <code>view</code>.
 */
public class TotalRevenueView extends RevenueTemplate{

    @Override
    protected void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception{
        System.out.printf("\n Total Revenue: %.2f %s\n", 
            totalRevenue.getValue(),
            totalRevenue.getCurrency().toString());
    }
    
    @Override
    protected void handleErrors(Exception exc){
        ErrorMessageHandler.getErrorMessageHandler().showErrorMessage
            ("The total revenue could not be shown at the moment.");
        ExceptionLogger.getExceptionLogger().logException(exc);
    }
}
