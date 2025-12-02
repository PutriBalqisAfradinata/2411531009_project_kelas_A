package service;

import DAO.UserRepo;
import error.ValidationException;
import model.user;

public class LoginService {

    private UserRepo repo;

    public LoginService() {
        repo = new UserRepo();
    }

    public void login(String username, String password) throws ValidationException {

        user u = repo.getByUsername(username);

        if (u == null) {
            throw new ValidationException("Username tidak ditemukan");
        }

        if (!u.getPassword().equals(password)) {
            throw new ValidationException("Password salah");
        }
    }
}
