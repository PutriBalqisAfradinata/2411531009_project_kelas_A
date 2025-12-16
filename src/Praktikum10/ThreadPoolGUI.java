package Praktikum10;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class ThreadPoolGUI extends JFrame {

    private JTextField threadCountField;
    private JTextField taskCountField;
    private JTextArea logArea;
    private DefaultListModel<String> taskListModel;
    private JLabel statusLabel;
    private JButton startButton;
    private JButton clearButton;

    public ThreadPoolGUI() {
        setTitle("Aplikasi ThreadPool dengan GUI");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        controlPanel.add(new JLabel("Jumlah Thread:"));
        threadCountField = new JTextField(5);
        controlPanel.add(threadCountField);

        controlPanel.add(new JLabel("Jumlah Tugas:"));
        taskCountField = new JTextField(5);
        controlPanel.add(taskCountField);

        startButton = new JButton("Mulai Proses");
        startButton.addActionListener(e -> startProcessing());
        controlPanel.add(startButton);

        clearButton = new JButton("Bersihkan Log");
        clearButton.addActionListener(e -> clearLog());
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);

        taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);

        logArea = new JTextArea();
        logArea.setEditable(false);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(taskList),
                new JScrollPane(logArea)
        );
        splitPane.setDividerLocation(250);

        add(splitPane, BorderLayout.CENTER);

        statusLabel = new JLabel("Siap");
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void startProcessing() {
        try {
            int threadCount = Integer.parseInt(threadCountField.getText());
            int taskCount = Integer.parseInt(taskCountField.getText());

            if (threadCount < 1 || taskCount < 1) {
                JOptionPane.showMessageDialog(this,
                        "Jumlah thread dan tugas harus lebih dari 0!",
                        "Input Tidak Valid",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            startButton.setEnabled(false);
            taskListModel.clear();
            logArea.append("=== Memulai Proses Baru ===\n");
            logArea.append("ThreadPool dengan " + threadCount + " worker threads\n\n");
            statusLabel.setText("Memproses...");

            ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);

            for (int i = 1; i <= taskCount; i++) {
                taskListModel.addElement("Task #" + i + " - Waiting");
            }

            for (int i = 1; i <= taskCount; i++) {
                Task task = new Task(i, logArea, taskListModel);
                threadPool.execute(task);
            }

            new Thread(() -> {
                threadPool.shutdown();
                try {
                    if (threadPool.awaitTermination(5, TimeUnit.MINUTES)) {
                        SwingUtilities.invokeLater(() -> {
                            logArea.append("\n=== Semua tugas selesai ===\n");
                            statusLabel.setText("Semua tugas selesai!");
                            startButton.setEnabled(true);
                        });
                    }
                } catch (InterruptedException e) {
                    threadPool.shutdownNow();
                }
            }).start();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Masukkan angka yang valid!",
                    "Input Tidak Valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearLog() {
        logArea.setText("");
        taskListModel.clear();
        statusLabel.setText("Log dibersihkan. Siap untuk proses baru.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ThreadPoolGUI().setVisible(true));
    }
}
