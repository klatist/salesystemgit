package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

/**
 * This class is an implementation of the <code>RevenueObserver</code> interface that handles
 * the logging of the total revenue by calculating the new <code>totalRevenue</code> and then calling
 * the <code>RevenueLogger</code> to log after updating the <code>totalRevenue</code>.
 */
public class TotalRevenueFileOutput implements RevenueObserver{
    private AmountDTO totalRevenue;
    private RevenueLogger logger;

    /**
     * Creates an instance of <code>TotalFileOutput</code> by creating <code>totalRevenue</code>
     * and the <code>logger</code>.
     */
    public TotalRevenueFileOutput(){
        totalRevenue = new AmountDTO();
        logger = new RevenueLogger();
    }


    /**
     * Updates the <code>totalRevenue</code> with the revenue from the most recent <code>sale</code> added
     * and then logs the new <code>totalRevenue</code> to a file.
     * 
     * @param saleRevenue  represents the revenue from the most recent <code>sale</code>.
     */
    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
        
        logger.logRevenue(totalRevenue);

    }

        
}
