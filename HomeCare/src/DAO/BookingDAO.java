package DAO;

import config.DBConnection;
import model.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void save(Booking b) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO bookings(user_id, service_name, provider_name, status, payment_status) VALUES (?,?,?,?,?)"
            );
            ps.setInt(1, b.getUser().getId());
            ps.setString(2, b.getService().getName());
            ps.setString(3, b.getProvider().getName());
            ps.setString(4, b.getStatus());
            ps.setString(5, b.getPaymentStatus());
            ps.executeUpdate();
        } catch (Exception e) {}
    }
    
    public List<Booking> getHistoryByUser(int userId) {
        List<Booking> list = new ArrayList<>();

        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM bookings WHERE user_id=? ORDER BY id DESC"
            );
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking b = new Booking(
                    rs.getInt("id"),
                    rs.getString("service_name"),
                    rs.getString("provider_name"),
                    rs.getString("status"),
                    rs.getString("payment_status")
                );
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void delete(int bookingId) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "DELETE FROM bookings WHERE id = ?"
            );
            ps.setInt(1, bookingId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
