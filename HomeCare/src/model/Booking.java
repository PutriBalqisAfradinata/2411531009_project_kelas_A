package model;

public class Booking {
    private int id;
    private User user;
    private Service service;
    private ServiceProvider provider;
    private String status;
    private String paymentStatus;

    public Booking(int id, User user, Service service, ServiceProvider provider) {
        this.id = id;
        this.user = user;
        this.service = service;
        this.provider = provider;
        this.status = "Pending";
        this.paymentStatus = "Unpaid";
    }
    
    public Booking(int id, String serviceName, String providerName, String status, String paymentStatus) {
        this.id = id;
        this.status = status;
        this.paymentStatus = paymentStatus;

        this.service = new HistoryService(serviceName);
        this.provider = new ServiceProvider(providerName);
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public Service getService() { return service; }
    public ServiceProvider getProvider() { return provider; }
    public String getStatus() { return status; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getServiceName() { return service.getName();}
    public String getProviderName() { return provider.getName(); }
    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentStatus(String status) {
        this.paymentStatus = status;
    }
}
