package latihan2;

import javax.swing.*;
import java.awt.*;

public class DownloadManagerGUI extends JFrame {

    private JProgressBar bar1, bar2, bar3;
    private JButton btnStart;

    public DownloadManagerGUI() {

        // Judul Frame
        setTitle("Download Manager App");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Judul di dalam frame
        JLabel title = new JLabel("Download Manager App", SwingConstants.CENTER);
        title.setBounds(0, 10, 500, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        // Label file 1
        JLabel l1 = new JLabel("File 1");
        l1.setBounds(50, 60, 80, 20);
        add(l1);

        bar1 = new JProgressBar(0, 100);
        bar1.setBounds(120, 60, 300, 20);
        add(bar1);

        // Label file 2
        JLabel l2 = new JLabel("File 2");
        l2.setBounds(50, 100, 80, 20);
        add(l2);

        bar2 = new JProgressBar(0, 100);
        bar2.setBounds(120, 100, 300, 20);
        add(bar2);

        // Label file 3
        JLabel l3 = new JLabel("File 3");
        l3.setBounds(50, 140, 80, 20);
        add(l3);

        bar3 = new JProgressBar(0, 100);
        bar3.setBounds(120, 140, 300, 20);
        add(bar3);

        // Tombol download
        btnStart = new JButton("Downloading");
        btnStart.setBounds(310, 200, 120, 30);
        add(btnStart);

        btnStart.addActionListener(e -> startDownload());
    }

    // Fungsi untuk memulai thread download
    private void startDownload() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 5) {
                bar1.setValue(i);
                sleep();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 5) {
                bar2.setValue(i);
                sleep();
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 5) {
                bar3.setValue(i);
                sleep();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    // Sleep untuk simulasi waktu download
    private void sleep() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {}
    }

    // Main program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DownloadManagerGUI().setVisible(true);
        });
    }
}
