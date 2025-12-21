package gui;

import javax.swing.*;
import java.awt.*;
import model.*;
import payment.*;
import DAO.PaymentDAO;

public class PaymentFrame extends JFrame {

    public PaymentFrame(Service service, Booking booking) {

        setTitle("HomeCare - Payment");
        setSize(420, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 420, 340);
        panel.setLayout(null);
        panel.setBackground(new Color(245, 247, 250));

        // Title
        JLabel lblTitle = new JLabel("Payment");
        lblTitle.setBounds(160, 20, 200, 30);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblTotal = new JLabel("Total: Rp " + service.calculatePrice());
        lblTotal.setBounds(120, 70, 250, 25);
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel lblMethod = new JLabel("Metode Pembayaran");
        lblMethod.setBounds(120, 110, 200, 20);

        JRadioButton rbCash = new JRadioButton("Cash");
        rbCash.setBounds(120, 135, 100, 25);

        JRadioButton rbWallet = new JRadioButton("Wallet");
        rbWallet.setBounds(220, 135, 100, 25);

        rbCash.setBackground(new Color(245, 247, 250));
        rbWallet.setBackground(new Color(245, 247, 250));

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbCash);
        bg.add(rbWallet);

        JButton btnPay = new JButton("Bayar");
        btnPay.setBounds(140, 190, 140, 40);
        btnPay.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnPay.setBackground(new Color(0, 123, 255));
        btnPay.setForeground(Color.WHITE);
        btnPay.setFocusPainted(false);

        JButton btnCancel = new JButton("Batal");
        btnCancel.setBounds(140, 240, 140, 35);
        btnCancel.setBackground(new Color(108, 117, 125));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFocusPainted(false);

        btnPay.addActionListener(e -> {

            if (!rbCash.isSelected() && !rbWallet.isSelected()) {
                JOptionPane.showMessageDialog(this, "Pilih metode pembayaran!");
                return;
            }

            Payment payment;
            String method;

            if (rbCash.isSelected()) {
                payment = new CashPayment();
                method = "Cash";
            } else {
                payment = new WalletPayment();
                method = "Wallet";
            }

            String status = payment.pay(service.calculatePrice());
            booking.setPaymentStatus(status);

            new PaymentDAO().save(
                new PaymentRecord(
                    booking.getId(),
                    method,
                    service.calculatePrice(),
                    status
                )
            );

            JOptionPane.showMessageDialog(
                this,
                "Pembayaran " + status,
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            );

            new MainMenuFrame();
            dispose();
        });

        btnCancel.addActionListener(e -> {
            new MainMenuFrame();
            dispose();
        });

        panel.add(lblTitle);
        panel.add(lblTotal);
        panel.add(lblMethod);
        panel.add(rbCash);
        panel.add(rbWallet);
        panel.add(btnPay);
        panel.add(btnCancel);

        add(panel);
        setVisible(true);
    }
}
