package se.kth.iv1350.salesystem.model; 
import java.time.LocalDateTime;

public class Sale {
    private LocalDateTime dateTime;
    

    // Konstruktor som automatiskt sätter aktuellt datum och tid
    public Sale() {
        this.dateTime = LocalDateTime.now();  // Sätter aktuellt datum och tid vid skapandet
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

