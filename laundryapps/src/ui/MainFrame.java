package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JButton btnPesanan, btnLayanan, btnPelanggan;
    private JButton btnPengguna, btnLaporan, btnProfile;
    private JButton btnKeluar;

    public MainFrame() {
        setTitle("Halaman Utama");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // sesuai modul (pakai null layout)

        // Judul
        JLabel lblTitle = new JLabel("Laundry Apps");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setForeground(Color.PINK);
        lblTitle.setBounds(170, 20, 200, 40);
        add(lblTitle);

        // Baris pertama tombol
        btnPesanan = new JButton("PESANAN");
        btnPesanan.setBounds(50, 100, 120, 50);
        add(btnPesanan);

        btnLayanan = new JButton("LAYANAN");
        btnLayanan.setBounds(190, 100, 120, 50);
        add(btnLayanan);

        btnPelanggan = new JButton("PELANGGAN");
        btnPelanggan.setBounds(330, 100, 120, 50);
        add(btnPelanggan);

        // Baris kedua tombol
        btnPengguna = new JButton("PENGGUNA");
        btnPengguna.setBounds(50, 170, 120, 50);
        add(btnPengguna);

        btnLaporan = new JButton("LAPORAN");
        btnLaporan.setBounds(190, 170, 120, 50);
        add(btnLaporan);

        btnProfile = new JButton("PROFILE");
        btnProfile.setBounds(330, 170, 120, 50);
        add(btnProfile);

        // Tombol keluar
        btnKeluar = new JButton("KELUAR");
        btnKeluar.setBounds(150, 250, 200, 50);
        add(btnKeluar);

        // Aksi tombol keluar
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Yakin mau keluar?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
