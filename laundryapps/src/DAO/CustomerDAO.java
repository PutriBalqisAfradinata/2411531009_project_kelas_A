package DAO;

import java.util.List;
import model.customer;

public interface CustomerDAO {
    void save(customer c);
    void update(customer c);
    void delete(String id);
    List<customer> show();
}
