package se.kth.iv1350.salesystem.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogHandler {
    private static final String FILE_NAME = "salesystem-log.txt";

    private PrintWriter logFile;

    public LogHandler(){
        try 
        {
            logFile = new PrintWriter(FILE_NAME);
        } 
        catch (IOException ioExc) 
        {
            System.out.println("Could not create log file");
            ioExc.printStackTrace();
        }

    }

    public void log(Exception exc){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append("At ").append(setTime());
        logMessageBuilder.append(", Following exception was thrown: ");
        logMessageBuilder.append(exc.getMessage());
        logFile.println(logMessageBuilder);
        System.out.println("\n");

    }

    private String setTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }
    
}
