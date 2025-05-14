package se.kth.iv1350.salesystem.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.salesystem.model.AmountDTO;

class RevenueLogger {
    private static final String REVENUE_FILE_NAME = "salerevenue-log.txt";
    private PrintWriter revenueLogFile;

    RevenueLogger(){
        try
        {
            revenueLogFile = new PrintWriter(new FileWriter(REVENUE_FILE_NAME, true), true);
            
        } 
        catch (IOException ioExc) 
        {
            System.out.println("Could not create log file");
            ioExc.printStackTrace();
        }
    }

    void logRevenue(AmountDTO totalRevenue){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append(setTime());
        logMessageBuilder.append(" Current total revenue: ");
        logMessageBuilder.append(totalRevenue.getValue()).append("").append(totalRevenue.getCurrency().toString());
        revenueLogFile.println(logMessageBuilder);
        System.out.println("\n");
        
    }

    private String setTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

}
