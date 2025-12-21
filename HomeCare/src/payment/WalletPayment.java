package payment;

import DAO.UserDAO;
import Manager.AuthManager;
import model.User;

public class WalletPayment implements Payment {

    @Override
    public String pay(double amount) {

        User user = AuthManager.getInstance().getCurrentUser();
        double balance = user.getWalletBalance();

        if (balance >= amount) {
            double newBalance = balance - amount;
            user.setWalletBalance(newBalance);

            new UserDAO().updateWalletBalance(user.getId(), newBalance);
            return "SUCCESS";
        }
        return "FAILED";
    }
}
