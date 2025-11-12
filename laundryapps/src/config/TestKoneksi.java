package config;

import java.sql.Connection;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection c = Database.koneksi();
        if (c != null) {
            System.out.println("Koneksi ke database BERHASIL!");
        } else {
            System.out.println("Koneksi ke database GAGAL!");
        }
    }
}
