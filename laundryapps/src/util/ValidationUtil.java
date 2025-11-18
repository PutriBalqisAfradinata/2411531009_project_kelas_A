package util;

import error.ValidationException;

public class ValidationUtil {

    public static void validate(String username, String password) throws ValidationException {

        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("Username tidak boleh kosong");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new ValidationException("Password tidak boleh kosong");
        }
    }
}
