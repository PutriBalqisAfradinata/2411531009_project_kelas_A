package model;

public abstract class Service {
    protected String name;
    protected double basePrice;

    public Service(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() { return name; }
    public abstract double calculatePrice();
}
