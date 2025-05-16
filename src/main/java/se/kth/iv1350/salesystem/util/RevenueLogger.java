package se.kth.iv1350.salesystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.salesystem.model.AmountDTO;

/**
 * This class is responsible for logging the total revenue of the sales since the program started.
 * The total revenue is written to a file along with a time stamp.
 */
class RevenueLogger {
    private static final String REVENUE_FILE_NAME = "salerevenue-log.txt";
    private PrintWriter revenueLogFile;

    /**
     * Creates an instance of <code>RevenueLogger</code> and opens the log file for appending.
     * If the file does not exist, it will created. If the file cannot be created, an error message
     * will be printed to the standard output.
     */
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

    /**
     * Logs the total revenue to a log file with a time stamp.
     * 
     * @param totalRevenue  represents the new <code>totalRevenue</code> that should be logged.
     */
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
