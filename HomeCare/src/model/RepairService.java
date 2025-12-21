package model;

public class RepairService extends Service {
    public RepairService() {
        super("Repair Service", 80000);
    }
    public double calculatePrice() {
        return basePrice + 20000;
    }
}
