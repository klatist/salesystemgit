package se.kth.iv1350.salesystem.model; 
import java.time.LocalDateTime;

import java.util.ArrayList;

public class Sale {
    private LocalDateTime dateTime;
    private double totalPrice;
    

    // Konstruktor som automatiskt sätter aktuellt datum och tid
    public Sale() {
        this.dateTime = LocalDateTime.now();  // Sätter aktuellt datum och tid vid skapandet
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
//
