package DAO;
import java.util.List;
import model.customer;

public interface CustomerDAO {
    void save(customer c);
    List<customer> show();
    void update(customer c);
    void delete(String id); 
}