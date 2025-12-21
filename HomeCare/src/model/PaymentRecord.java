package model;

public class PaymentRecord {
    private int bookingId;
    private String method;
    private double amount;
    private String status;

    public PaymentRecord(int bookingId, String method, double amount, String status) {
        this.bookingId = bookingId;
        this.method = method;
        this.amount = amount;
        this.status = status;
    }

    public int getBookingId() { return bookingId; }
    public String getMethod() { return method; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
