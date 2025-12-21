package model;

public class CleaningService extends Service {
    public CleaningService() {
        super("Cleaning Service", 50000);
    }
    public double calculatePrice() {
        return basePrice;
    }
}
