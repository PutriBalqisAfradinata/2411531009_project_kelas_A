package gui;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        setTitle("HomeCare - Main Menu");
        setSize(420, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 420, 360);
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("HOMECARE");
        lblTitle.setBounds(140, 25, 200, 30);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(33, 37, 41));

        JLabel lblSub = new JLabel("Main Menu");
        lblSub.setBounds(165, 55, 150, 20);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSub.setForeground(Color.GRAY);

        JButton btnBooking = createButton("Buat Booking");
        btnBooking.setBounds(110, 100, 200, 45);

        JButton btnHistory = createButton("Booking History");
        btnHistory.setBounds(110, 155, 200, 45);

        JButton btnLogout = createButton("Logout");
        btnLogout.setBounds(110, 210, 200, 45);
        btnLogout.setBackground(new Color(220, 53, 69)); 

        btnBooking.addActionListener(e -> {
            new BookingFrame();
            dispose();
        });

        btnHistory.addActionListener(e -> {
            new BookingHistoryFrame();
            dispose();
        });

        btnLogout.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        panel.add(lblTitle);
        panel.add(lblSub);
        panel.add(btnBooking);
        panel.add(btnHistory);
        panel.add(btnLogout);

        add(panel);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(new Color(0, 123, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }
}
