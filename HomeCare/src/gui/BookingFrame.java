package gui;

import javax.swing.*;
import java.awt.*;
import model.*;
import Manager.AuthManager;



public class BookingFrame extends JFrame {

    public BookingFrame() {
        setTitle("HomeCare - Booking Service");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 420);
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 250));

        JLabel lblTitle = new JLabel("Buat Booking");
        lblTitle.setBounds(160, 20, 200, 30);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel lblSub = new JLabel("Pilih layanan & provider");
        lblSub.setBounds(170, 50, 200, 20);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSub.setForeground(Color.GRAY);

        JLabel lblService = new JLabel("Service");
        lblService.setBounds(80, 100, 100, 20);

        JComboBox<String> cbService = new JComboBox<>(
                new String[]{"Cleaning Service", "Laundry Pickup", "Repair Service"}
        );
        cbService.setBounds(200, 95, 200, 35);

        JLabel lblProvider = new JLabel("Provider");
        lblProvider.setBounds(80, 155, 100, 20);

        JComboBox<String> cbProvider = new JComboBox<>(
                new String[]{"Budi", "Andi", "Siti"}
        );
        cbProvider.setBounds(200, 150, 200, 35);

        JButton btnSubmit = new JButton("Lanjut ke Payment");
        btnSubmit.setBounds(140, 230, 220, 45);
        btnSubmit.setBackground(new Color(0, 123, 255));
        btnSubmit.setForeground(Color.WHITE);

        JButton btnBack = new JButton("Kembali");
        btnBack.setBounds(140, 290, 220, 40);
        btnBack.setBackground(new Color(108, 117, 125));
        btnBack.setForeground(Color.WHITE);

        btnSubmit.addActionListener(e -> {

            String serviceName = (String) cbService.getSelectedItem();
            String providerName = (String) cbProvider.getSelectedItem();

            Service service;
            if (serviceName.equals("Cleaning Service")) {
                service = new CleaningService();
            } else if (serviceName.equals("Laundry Pickup")) {
                service = new LaundryPickupService();
            } else {
                service = new RepairService();
            }

            ServiceProvider provider = new ServiceProvider(providerName);

            Booking booking = new Booking(
            	    0,
            	    AuthManager.getInstance().getCurrentUser(),
            	    service,
            	    provider
            	);

            new PaymentFrame(service, booking);
            dispose();
        });

        btnBack.addActionListener(e -> {
            new MainMenuFrame();
            dispose();
        });

        panel.add(lblTitle);
        panel.add(lblSub);
        panel.add(lblService);
        panel.add(cbService);
        panel.add(lblProvider);
        panel.add(cbProvider);
        panel.add(btnSubmit);
        panel.add(btnBack);

        add(panel);
        setVisible(true);
    }
}
