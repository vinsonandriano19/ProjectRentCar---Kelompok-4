public abstract class Transportasi{

    String PlatTransportasi;
    int JumlahPenumpang;
    String StatusTransportasi;
    int HargaSewa;


    public Transportasi() {
    }

    public Transportasi(String PlatTransportasi, int JumlahPenumpang, String StatusTransportasi, int HargaSewa) {
        this.PlatTransportasi = PlatTransportasi;
        this.JumlahPenumpang = JumlahPenumpang;
        this.StatusTransportasi = StatusTransportasi;
        this.HargaSewa = HargaSewa;
    }

    public String getPlatTransportasi() {
        return this.PlatTransportasi;
    }

    public void setPlatTransportasi(String PlatTransportasi) {
        this.PlatTransportasi = PlatTransportasi;
    }

    public int getJumlahPenumpang() {
        return this.JumlahPenumpang;
    }

    public void setJumlahPenumpang(int JumlahPenumpang) {
        this.JumlahPenumpang = JumlahPenumpang;
    }

    public String getStatusTransportasi() {
        return this.StatusTransportasi;
    }

    public void setStatusTransportasi(String StatusTransportasi) {
        this.StatusTransportasi = StatusTransportasi;
    }

    public int getHargaSewa() {
        return this.HargaSewa;
    }

    public void setHargaSewa(int HargaSewa) {
        this.HargaSewa = HargaSewa;
    }
}