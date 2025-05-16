package se.kth.iv1350.salesystem.view;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

/**
 * This class is an implementation of the <code>RevenueObserver</code> that displays the
 * <code>totalRevenue</code> to the <code>view</code>.
 */
public class TotalRevenueView implements RevenueObserver{
    private AmountDTO totalRevenue;

    /**
     * Creates an instance of <code>TotalRevenueView</code> that holds the <code>totalRevenue</code>.
     */
    public TotalRevenueView(){
        totalRevenue = new AmountDTO();
    }

    /**
     * Calculates the new <code>totalRevenue</code> and then prints the <code>totalRevenue</code>.
     * 
     * @param saleRevenue represents the revenue from the most recent <code>sale</code>.
     */
    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){

        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
        printTotalRevenue();
    }

    private void printTotalRevenue(){
        System.out.printf("\n Total Revenue: %.2f %s\n", 
            totalRevenue.getValue(),
            totalRevenue.getCurrency().toString());
    }
}
