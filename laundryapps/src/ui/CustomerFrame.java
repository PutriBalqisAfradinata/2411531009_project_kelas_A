package ui;

import javax.swing.*;
import DAO.CustomerRepo;
import table.TableCustomer;
import model.CustomerBuilder;
import model.customer;

import java.awt.event.*;

public class CustomerFrame extends JFrame {

    private JTextField txtNama, txtEmail, txtAlamat, txtHp;
    private JTable table;
    private CustomerRepo repo = new CustomerRepo();
    private String selectedId = null;

    public CustomerFrame() {
        setTitle("PELANGGAN");
        setSize(650, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Nama");
        l1.setBounds(30, 30, 100, 25);
        add(l1);

        txtNama = new JTextField();
        txtNama.setBounds(150, 30, 300, 25);
        add(txtNama);

        JLabel l2 = new JLabel("Email");
        l2.setBounds(30, 70, 100, 25);
        add(l2);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 70, 300, 25);
        add(txtEmail);

        JLabel l3 = new JLabel("Alamat");
        l3.setBounds(30, 110, 100, 25);
        add(l3);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(150, 110, 300, 25);
        add(txtAlamat);

        JLabel l4 = new JLabel("No HP");
        l4.setBounds(30, 150, 100, 25);
        add(l4);

        txtHp = new JTextField();
        txtHp.setBounds(150, 150, 300, 25);
        add(txtHp);

        JButton btnSave = new JButton("Simpan");
        btnSave.setBounds(150, 200, 100, 30);
        add(btnSave);

        JButton btnCancel = new JButton("Batal");
        btnCancel.setBounds(260, 200, 100, 30);
        add(btnCancel);

        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 260, 580, 180);
        add(sp);

        loadTable();

        btnSave.addActionListener(e -> {
            customer c = new CustomerBuilder()
                    .setId(selectedId == null ? "" : selectedId)
                    .setNama(txtNama.getText())
                    .setEmail(txtEmail.getText())
                    .setAlamat(txtAlamat.getText())
                    .setHp(txtHp.getText())
                    .build();

            if (selectedId == null) {
                repo.save(c);
            } else {
                repo.update(c);
            }

            clear();
            loadTable();
        });

        btnCancel.addActionListener(e -> clear());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                selectedId = table.getValueAt(row, 0).toString();
                txtNama.setText(table.getValueAt(row, 1).toString());
                txtEmail.setText(table.getValueAt(row, 2).toString());
                txtAlamat.setText(table.getValueAt(row, 3).toString());
                txtHp.setText(table.getValueAt(row, 4).toString());
            }
        });
    }

    private void clear() {
        txtNama.setText("");
        txtEmail.setText("");
        txtAlamat.setText("");
        txtHp.setText("");
        selectedId = null;
    }

    private void loadTable() {
        table.setModel(new TableCustomer(repo.show()));
    }
}
