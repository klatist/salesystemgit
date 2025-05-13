package se.kth.iv1350.salesystem.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogHandler {
    private static final String EXCEPTION_FILE_NAME = "saleexception-log.txt";
    

    private PrintWriter exceptionLogFile;

    public LogHandler(){
        try 
        {
            exceptionLogFile = new PrintWriter(EXCEPTION_FILE_NAME);
            
        } 
        catch (IOException ioExc) 
        {
            System.out.println("Could not create log file");
            ioExc.printStackTrace();
        }
    }

    public void logException(Exception exc){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("At ").append(setTime());
        logMessageBuilder.append(", Following exception was thrown: ");
        logMessageBuilder.append(exc.getMessage());
        exceptionLogFile.println(logMessageBuilder);
        System.out.println("\n");

    }

    
    private String setTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }
    
}
