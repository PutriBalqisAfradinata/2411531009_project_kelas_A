package Manager;

import DAO.UserDAO;
import model.User;

public class AuthManager {
    private static AuthManager instance;
    private User currentUser;

    private AuthManager() {}

    public static AuthManager getInstance() {
        if (instance == null) instance = new AuthManager();
        return instance;
    }

    public boolean login(String username, String password) {
        UserDAO dao = new UserDAO();
        currentUser = dao.login(username, password);
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
