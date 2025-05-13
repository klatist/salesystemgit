package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

class TotalRevenueView implements RevenueObserver{
    private AmountDTO totalRevenue;

    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){

        printToFile();

    }

        
}
