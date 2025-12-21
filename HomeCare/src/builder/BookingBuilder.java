package builder;

import model.*;

public class BookingBuilder {
    private int id;
    private User user;
    private Service service;
    private ServiceProvider provider;

    public BookingBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BookingBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public BookingBuilder setService(Service service) {
        this.service = service;
        return this;
    }

    public BookingBuilder setProvider(ServiceProvider provider) {
        this.provider = provider;
        return this;
    }

    public Booking build() {
        return new Booking(id, user, service, provider);
    }
}
