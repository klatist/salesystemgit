package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

public class TotalRevenueFileOutput implements RevenueObserver{
    private AmountDTO totalRevenue;
    private RevenueLogger logger;

    public TotalRevenueFileOutput(){
        totalRevenue = new AmountDTO();
        logger = new RevenueLogger();
    }


    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
        
        logger.logRevenue(totalRevenue);

    }

        
}
