package latihan2;

public class DownloadLambda {
    public static void main(String[] args) throws InterruptedException {

        Thread f1 = new Thread(() -> {
            for (int i = 10; i <= 100; i += 10) {
                System.out.println("File-1 : " + i + "%");
                try { Thread.sleep(500); } catch (Exception e) {}
            }
            System.out.println("File-1 selesai diunduh!");
        });

        Thread f2 = new Thread(() -> {
            for (int i = 10; i <= 100; i += 10) {
                System.out.println("File-2 : " + i + "%");
                try { Thread.sleep(500); } catch (Exception e) {}
            }
            System.out.println("File-2 selesai diunduh!");
        });

        Thread f3 = new Thread(() -> {
            for (int i = 10; i <= 100; i += 10) {
                System.out.println("File-3 : " + i + "%");
                try { Thread.sleep(500); } catch (Exception e) {}
            }
            System.out.println("File-3 selesai diunduh!");
        });

        f1.start();
        f2.start();
        f3.start();

        f1.join();
        f2.join();
        f3.join();

        System.out.println("Semua file selesai diunduh!");
    }
}

