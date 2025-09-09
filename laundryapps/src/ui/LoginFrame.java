package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import model.user;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login - Laundry Apps");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Judul
        JLabel lblTitle = new JLabel("Laundry Apps");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitle.setForeground(new Color(255, 51, 153)); // warna pink
        lblTitle.setBounds(100, 10, 200, 30);
        add(lblTitle);

        // Tagline
        JLabel lblTagline = new JLabel("Bersih, Cepat, dan Terpercaya");
        lblTagline.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblTagline.setForeground(Color.GRAY);
        lblTagline.setBounds(85, 40, 200, 20);
        add(lblTagline);

        // Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 80, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 80, 180, 25);
        add(txtUsername);

        // Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(30, 120, 80, 25);
        add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(120, 120, 180, 25);
        add(txtPassword);

        // Button Login
        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 160, 100, 30);
        add(btnLogin);

        // Event handler login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = txtUsername.getText();
                String p = txtPassword.getText();

                if (user.login(u, p)) {
                    JOptionPane.showMessageDialog(null, "Login berhasil");
                    new MainFrame().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username / Password salah");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
