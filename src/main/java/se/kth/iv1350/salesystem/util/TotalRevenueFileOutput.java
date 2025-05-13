package se.kth.iv1350.salesystem.util;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.salesystem.model.AmountDTO;
import se.kth.iv1350.salesystem.model.RevenueObserver;

public class TotalRevenueFileOutput implements RevenueObserver{
    private AmountDTO totalRevenue;
    private static final String REVENUE_FILE_NAME = "salerevenue-log.txt";
    private PrintWriter revenueLogFile;



    @Override
    public void updateTotalRevenue(AmountDTO saleRevenue){
        double newTotalRevenue = totalRevenue.getValue() + saleRevenue.getValue();
        totalRevenue = new AmountDTO(newTotalRevenue);
        
        fileLogger.logRevenue(totalRevenue);

    }

    public void logRevenue(AmountDTO totalRevenue){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append(setTime());
        logMessageBuilder.append("Current total revenue: ");
        logMessageBuilder.append(totalRevenue.getValue()).append(totalRevenue.getCurrency().toString());
        revenueLogFile.println(logMessageBuilder);
        System.out.println("\n");
        
    }

    private String setTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

        
}
