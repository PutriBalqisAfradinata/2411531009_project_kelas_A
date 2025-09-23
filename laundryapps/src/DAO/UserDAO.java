package DAO;

import java.util.List;
import model.user;

public interface UserDAO {
    void save(user user);
    List<user> show();
    void delete(String id);
    void update(user user);
}
