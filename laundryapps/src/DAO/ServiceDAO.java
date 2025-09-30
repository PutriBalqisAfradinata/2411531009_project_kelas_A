package DAO;

import java.util.List;
import model.service;

public interface ServiceDAO {
    void save(service s);
    List<service> show();
    void update(service s);
    void delete(String id);
}
