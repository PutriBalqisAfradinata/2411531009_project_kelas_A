package DAO;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.customer;
import config.Database;

public class CustomerRepo implements CustomerDAO {
	private Connection conn = Database.koneksi();

    @Override
    public void save(customer c) {
        String sql = "INSERT INTO customer(nama, alamat, nomor_hp) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNama());
            ps.setString(2, c.getAlamat());
            ps.setString(3, c.getNoHp());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer berhasil ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal tambah customer: " + e.getMessage());
        }
    }

    @Override
    public List<customer> show() {
        List<customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                customer c = new customer();
                c.setId(rs.getString("id_customer"));   // id_customer di DB → String di class
                c.setNama(rs.getString("nama"));
                c.setAlamat(rs.getString("alamat"));
                c.setNoHp(rs.getString("nomor_hp"));
                list.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal load customer: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(customer c) {
        String sql = "UPDATE customer SET nama=?, alamat=?, nomor_hp=? WHERE id_customer=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNama());
            ps.setString(2, c.getAlamat());
            ps.setString(3, c.getNoHp());
            ps.setString(4, c.getId()); // karena id di class String
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer berhasil diupdate!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update customer: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM customer WHERE id_customer=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer berhasil dihapus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus customer: " + e.getMessage());
        }
    }
}
