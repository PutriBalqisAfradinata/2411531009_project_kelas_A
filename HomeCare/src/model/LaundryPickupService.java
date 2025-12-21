package model;

public class LaundryPickupService extends Service {
    public LaundryPickupService() {
        super("Laundry Pickup", 20000);
    }
    public double calculatePrice() {
        return basePrice;
    }
}
