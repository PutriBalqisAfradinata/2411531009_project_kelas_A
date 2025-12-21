package DAO;

import config.DBConnection;
import model.User;
import java.sql.*;

public class UserDAO {

	public User login(String username, String password) {
	    try {
	        Connection c = DBConnection.getConnection();
	        PreparedStatement ps = c.prepareStatement(
	            "SELECT * FROM users WHERE username=? AND password=?"
	        );
	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new User(
	                rs.getInt("id"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("name"),
	                rs.getString("phone"),
	                rs.getDouble("wallet_balance")
	            );
	        }
	    } catch (Exception e) {   
	        e.printStackTrace();
	    }
	    return null;
	}
    public void updateWalletBalance(int userId, double newBalance) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "UPDATE users SET wallet_balance=? WHERE id=?"
            );
            ps.setDouble(1, newBalance);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
