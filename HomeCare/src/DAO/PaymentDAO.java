package DAO;

import config.DBConnection;
import model.PaymentRecord;
import java.sql.*;

public class PaymentDAO {

    public void save(PaymentRecord p) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO payments(booking_id, method, amount, status) VALUES (?,?,?,?)"
            );
            ps.setInt(1, p.getBookingId());
            ps.setString(2, p.getMethod());
            ps.setDouble(3, p.getAmount());
            ps.setString(4, p.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {}
    }
}
