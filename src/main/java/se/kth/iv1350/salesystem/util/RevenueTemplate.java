package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;
import java.lang.Exception;

public abstract class RevenueTemplate implements RevenueObserver{
    private AmountDTO totalRevenue = new AmountDTO();
    
    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        calculateTotalRevenue(saleRevenue);
        printTotalRevenue();
    }

    private void calculateTotalRevenue(AmountDTO saleRevenue)
    {
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
    }

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

