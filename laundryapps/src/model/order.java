package model;

public class order {
    private String id;
    private String idCustomer;
    private String idService;
    private String idUser;
    private double total;
    private String tanggal;
    private String tanggalSelesai;
    private String status;
    private String statusPembayaran;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }
    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }
    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", idCustomer=" + idCustomer +
                ", idService=" + idService + ", idUser=" + idUser +
                ", total=" + total + ", tanggal=" + tanggal +
                ", tanggalSelesai=" + tanggalSelesai +
                ", status=" + status + ", statusPembayaran=" + statusPembayaran + "]";
    }
}
