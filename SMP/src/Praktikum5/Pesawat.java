package Praktikum5;

class Pesawat extends Kendaraan implements TransportasiUdara, Maskapai {
    private String tipePesawat;

    public Pesawat(String merk, String model, int tahunProduksi, String tipePesawat) {
        super(merk, model, tahunProduksi);
        this.tipePesawat = tipePesawat;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin: Bersiap lepas landas");
    }

    @Override
    public String jenisBahanBakar() {
        return "Avtur";
    }

    @Override
    public void jenisPenerbangan() {
        System.out.println("Jenis Penerbangan: Internasional.");
    }

    @Override
    public String namaMaskapai() {
        return "Garuda Indonesia";
    }

    public void fiturPesawat() {
        System.out.println("Fitur Pesawat: Dilengkapi hiburan, WiFi, dan tempat duduk ergonomis.");
    }
}