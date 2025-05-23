package se.kth.iv1350.salesystem.util;

import se.kth.iv1350.salesystem.model.AmountDTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.Exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TotalRevenueFileOutputTest {
    private TotalRevenueFileOutput observer;
    private AmountDTO totalRevenue;
    
    @BeforeEach
    public void setup() throws Exception{
        totalRevenue = new AmountDTO(100);
        
        observer = new TotalRevenueFileOutput(){
        @Override
        protected void doPrintTotalRevenue(AmountDTO totalRevenue) throws Exception{
            throw new Exception("Could not print");}
        };
    }

    @AfterEach
    public void tearDown(){
        totalRevenue = null;
        observer = null;
    }
    
    @Test
    public void testHandleErrors() throws IOException{
        observer.updateTotalRevenue(totalRevenue);
        
        Path logFilePath = Paths.get("C:","objdes","salesystemgit","saleexception-log.txt");
        List<String> lines = Files.readAllLines(logFilePath);
        boolean found = lines.stream().anyMatch(line -> line.contains("Could not print"));

        assertTrue(found, "Logfile should contain the error message.");
    }
}
