package ui;

import javax.swing.*;
import DAO.ServiceRepo;
import table.TableService;
import model.service;

import java.util.List;

public class ServiceFrame extends JFrame {
    private JTextField txtJenis, txtHarga, txtStatus;
    private JTable table;
    private ServiceRepo repo;
    private String selectedId = null;

    public ServiceFrame() {
        setTitle("Manajemen Service");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblJenis = new JLabel("Jenis:");
        lblJenis.setBounds(20, 20, 80, 25);
        add(lblJenis);
        txtJenis = new JTextField();
        txtJenis.setBounds(120, 20, 200, 25);
        add(txtJenis);

        JLabel lblHarga = new JLabel("Harga:");
        lblHarga.setBounds(20, 60, 80, 25);
        add(lblHarga);
        txtHarga = new JTextField();
        txtHarga.setBounds(120, 60, 200, 25);
        add(txtHarga);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(20, 100, 80, 25);
        add(lblStatus);
        txtStatus = new JTextField();
        txtStatus.setBounds(120, 100, 200, 25);
        add(txtStatus);

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

        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 600, 180);
        add(sp);

        repo = new ServiceRepo();
        loadTable();

        // Tombol Save
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                service s = new service();
                s.setJenis(txtJenis.getText());
                s.setHarga(Double.parseDouble(txtHarga.getText()));
                s.setStatus(txtStatus.getText());
                repo.save(s);
                loadTable();
                reset();
            }
        });

        // Tombol Update
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (selectedId != null) {
                    service s = new service();
                    s.setId(selectedId);
                    s.setJenis(txtJenis.getText());
                    s.setHarga(Double.parseDouble(txtHarga.getText()));
                    s.setStatus(txtStatus.getText());
                    repo.update(s);
                    loadTable();
                    reset();
                }
            }
        });

        // Tombol Delete
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (selectedId != null) {
                    repo.delete(selectedId);
                    loadTable();
                    reset();
                }
            }
        });

        // Tombol Cancel
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                reset();
            }
        });

        // Event klik tabel
        table.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    selectedId = (String) table.getValueAt(row, 0);
                    txtJenis.setText((String) table.getValueAt(row, 1));
                    txtHarga.setText(table.getValueAt(row, 2).toString());
                    txtStatus.setText((String) table.getValueAt(row, 3));
                }
            }
        });
    }

    private void loadTable() {
        List<service> list = repo.show();
        TableService model = new TableService(list);
        table.setModel(model);
    }

    private void reset() {
        txtJenis.setText("");
        txtHarga.setText("");
        txtStatus.setText("");
        selectedId = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ServiceFrame().setVisible(true);
            }
        });
    }
}