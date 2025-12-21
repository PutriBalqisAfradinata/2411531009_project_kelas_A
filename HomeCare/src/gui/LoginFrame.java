package gui;

import javax.swing.*;
import java.awt.*;
import Manager.AuthManager;

public class LoginFrame extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginFrame() {
        setTitle("Login - HomeCare");
        setSize(420, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Background panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 420, 340);
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 250)); 

        // Title
        JLabel lblTitle = new JLabel("HOMECARE LOGIN");
        lblTitle.setBounds(100, 30, 300, 30);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(33, 37, 41));

        // Username
        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(70, 90, 100, 20);
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        txtUser = new JTextField();
        txtUser.setBounds(70, 115, 280, 35);
        txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Password
        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(70, 160, 100, 20);
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        txtPass = new JPasswordField();
        txtPass.setBounds(70, 185, 280, 35);
        txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(140, 240, 140, 40);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBackground(new Color(0, 123, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);

        btnLogin.addActionListener(e -> {
            String username = txtUser.getText();
            String password = new String(txtPass.getPassword());

            if (AuthManager.getInstance().login(username, password)) {
                new MainMenuFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Username atau password salah",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        panel.add(lblTitle);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);

        add(panel);
        setVisible(true);
    }
}
