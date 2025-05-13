package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

class TotalRevenueView implements RevenueObserver{
    private AmountDTO totalRevenue;

    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){

        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
        printTotalRevenue();
    }

    private void printTotalRevenue(){
        System.out.printf("\n Total Revenue: %.2f %s", 
            totalRevenue.getValue(),
            totalRevenue.getCurrency().toString());
    }
}
