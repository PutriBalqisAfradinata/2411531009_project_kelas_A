package gui;

import DAO.BookingDAO;
import Manager.AuthManager;
import model.Booking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.util.List;

public class BookingHistoryFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public BookingHistoryFrame() {
        setTitle("Booking History");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
            new String[]{"ID", "Service", "Provider", "Status", "Payment"}, 0
        );

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new java.awt.Color(245, 247, 250));

        JButton btnDelete = new JButton("Batalkan Booking");
        btnDelete.setPreferredSize(new java.awt.Dimension(180, 35));

        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Pilih booking terlebih dahulu",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin membatalkan booking?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                int bookingId = (int) table.getValueAt(row, 0);
                new BookingDAO().delete(bookingId);
                model.removeRow(row);

                JOptionPane.showMessageDialog(
                    this,
                    "Booking berhasil dibatalkan"
                );
            }
        });

        loadData();
        setVisible(true);
    }


    private void loadData() {
        int userId = AuthManager.getInstance().getCurrentUser().getId();
        List<Booking> list = new BookingDAO().getHistoryByUser(userId);

        for (Booking b : list) {
            model.addRow(new Object[]{
                b.getId(),
                b.getServiceName(),
                b.getProviderName(),
                b.getStatus(),
                b.getPaymentStatus()
            });
        }
    }
}
