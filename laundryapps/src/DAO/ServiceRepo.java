package DAO;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

import config.Database;
import model.service;

public class ServiceRepo implements ServiceDAO {
    private Connection conn = Database.koneksi(); 

    @Override
    public void save(service s) {
        String sql = "INSERT INTO service(jenis, harga, status) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getJenis());
            ps.setDouble(2, s.getHarga());
            ps.setString(3, s.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Service berhasil ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal tambah service: " + e.getMessage());
        }
    }

    @Override
    public List<service> show() {
        List<service> list = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                service s = new service();
                s.setId(rs.getString("id_service"));
                s.setJenis(rs.getString("jenis"));
                s.setHarga(rs.getDouble("harga"));
                s.setStatus(rs.getString("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal load service: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(service s) {
        String sql = "UPDATE service SET jenis=?, harga=?, status=? WHERE id_service=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getJenis());
            ps.setDouble(2, s.getHarga());
            ps.setString(3, s.getStatus());
            ps.setString(4, s.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Service berhasil diupdate!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update service: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM service WHERE id_service=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Service berhasil dihapus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus service: " + e.getMessage());
        }
    }
}