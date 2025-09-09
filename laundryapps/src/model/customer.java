package model;

public class customer {
    private String id;
    private String nama;
    private String alamat;
    private String noHp;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", nama=" + nama + ", alamat=" + alamat + ", noHp=" + noHp + "]";
    }
}
