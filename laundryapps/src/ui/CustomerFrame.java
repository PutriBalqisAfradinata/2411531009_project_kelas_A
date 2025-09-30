package ui;

import javax.swing.*;
import DAO.CustomerRepo;
import table.TableCustomer;
import model.customer;

import java.util.List;

public class CustomerFrame extends JFrame {
    private JTextField txtNama, txtAlamat, txtNoHp;
    private JTable table;
    private CustomerRepo repo;
    private String selectedId = null;

    public CustomerFrame() {
        setTitle("Manajemen Customer");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label dan TextField
        JLabel lblNama = new JLabel("Nama:");
        lblNama.setBounds(20, 20, 80, 25);
        add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(120, 20, 200, 25);
        add(txtNama);

        JLabel lblAlamat = new JLabel("Alamat:");
        lblAlamat.setBounds(20, 60, 80, 25);
        add(lblAlamat);
        txtAlamat = new JTextField();
        txtAlamat.setBounds(120, 60, 200, 25);
        add(txtAlamat);

        JLabel lblNoHp = new JLabel("No HP:");
        lblNoHp.setBounds(20, 100, 80, 25);
        add(lblNoHp);
        txtNoHp = new JTextField();
        txtNoHp.setBounds(120, 100, 200, 25);
        add(txtNoHp);

        // Tombol
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(350, 20, 100, 25);
        add(btnSave);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(350, 60, 100, 25);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(350, 100, 100, 25);
        add(btnDelete);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(350, 140, 100, 25);
        add(btnCancel);

        // Tabel
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 600, 180);
        add(sp);

        repo = new CustomerRepo();
        loadTable();

        // Event Tombol Save
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                customer c = new customer();
                c.setNama(txtNama.getText());
                c.setAlamat(txtAlamat.getText());
                c.setNoHp(txtNoHp.getText());
                repo.save(c);
                loadTable();
                reset();
            }
        });

        // Event Tombol Update
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (selectedId != null) {
                    customer c = new customer();
                    c.setId(selectedId);
                    c.setNama(txtNama.getText());
                    c.setAlamat(txtAlamat.getText());
                    c.setNoHp(txtNoHp.getText());
                    repo.update(c);
                    loadTable();
                    reset();
                }
            }
        });

        // Event Tombol Delete
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (selectedId != null) {
                    repo.delete(selectedId);
                    loadTable();
                    reset();
                }
            }
        });

        // Event Tombol Cancel
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                reset();
            }
        });

        // Event Klik Tabel
        table.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    selectedId = (String) table.getValueAt(row, 0);
                    txtNama.setText((String) table.getValueAt(row, 1));
                    txtAlamat.setText((String) table.getValueAt(row, 2));
                    txtNoHp.setText((String) table.getValueAt(row, 3));
                }
            }
        });
    }

    // Muat ulang data tabel
    private void loadTable() {
        List<customer> list = repo.show();
        TableCustomer model = new TableCustomer(list);
        table.setModel(model);
    }

    // Reset input
    private void reset() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtNoHp.setText("");
        selectedId = null;
    }

    // Untuk testing langsung jalankan CustomerFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }
}
