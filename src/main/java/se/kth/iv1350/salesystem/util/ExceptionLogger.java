package se.kth.iv1350.salesystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This singleton class is responsible for logging exceptions that occur during the execution
 * of the program. The exceptions are written to a log file along with a time stamp.
 */
public class ExceptionLogger {
    private static final ExceptionLogger EXCEPTION_LOGGER = new ExceptionLogger();
    private static final String EXCEPTION_FILE_NAME = "saleexception-log.txt";
    

    private PrintWriter exceptionLogFile;

    /**
     * Creates an instance of <code>ExceptionLogger</code> and opens the log file for writing.
     * If the file does not exist, it will created. If the file cannot be created, an error message
     * will be printed to the standard output.
     */
    private ExceptionLogger(){
        try 
        {
            exceptionLogFile = new PrintWriter(new FileWriter(EXCEPTION_FILE_NAME, true), true);
        } 
        catch (IOException ioExc) 
        {
            System.out.println("Could not create log file");
            ioExc.printStackTrace();
        }
    }
    /**
     * Hands out the Exception logger so other class can call the methods.
     * @return EXCEPTION_LOGGER
     */
    public static ExceptionLogger getExceptionLogger(){
        return EXCEPTION_LOGGER;
    }

    /**
     * Logs the specified exception to the log file with a time stamp.
     * 
     * @param exc represents the exception that was thrown during program execution 
     * that should be logged.
     */
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
