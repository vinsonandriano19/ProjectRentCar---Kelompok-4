import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// Merupakan inheritance dari Transaksi
public class TransaksiPeminjaman extends Transaksi{

    private ArrayList <Mobil> mobils = new ArrayList<>();
    private ArrayList <Bus> buss = new ArrayList<>();
    private ArrayList <Pelanggan> pelanggans = new ArrayList<>();
    
    private int deposit;
    private String lokasiPinjam;
    private String tanggalPinjam;
    private Mobil mobilPinjam;
    private Bus busPinjam;
    private Pelanggan pelangganPinjam;
    private String statusPinjam;

    // constructors
    public TransaksiPeminjaman() {
    }


    public TransaksiPeminjaman( String nomorTransaksi, String kodeTransport, String kodePelanggan, String lokasiPinjam, String tanggalPinjam, int deposit, int biaya, int lamaSewa, String statusPinjam) throws FileNotFoundException, IOException {
        this.nomorTransaksi = nomorTransaksi;
        if (kodeTransport.substring(0, 1).equalsIgnoreCase("m")) {
            Mobil.updateMobil(mobils);
            for (Mobil mobil : mobils) {
                if (mobil.getKodeTransport().equalsIgnoreCase(kodeTransport)) {
                    this.mobilPinjam = mobil;
                    this.busPinjam = null;
                    break;
                }
            }
        } else if (kodeTransport.substring(0, 1).equalsIgnoreCase("b")) {
            Bus.updateBus(buss);
            for (Bus bus : buss) {
                if (bus.getKodeTransport().equalsIgnoreCase(kodeTransport)) {
                    this.busPinjam = bus;
                    this.mobilPinjam = null;
                    break;
                }
            }
        }
        Pelanggan.updatePelanggan(pelanggans);
        for (Pelanggan pelanggan : pelanggans) {
            if (pelanggan.getKodePelanggan().equalsIgnoreCase(kodePelanggan)) {
                this.pelangganPinjam = pelanggan;
                break;
            }
        }
        this.lokasiPinjam = lokasiPinjam;
        this.tanggalPinjam = tanggalPinjam;
        this.deposit = deposit;
        this.biaya = biaya;
        this.lamaSewa = lamaSewa;
        this.statusPinjam = statusPinjam;
    }

    
    // setter getter
    public int getDeposit() {
        return this.deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getLokasiPinjam() {
        return this.lokasiPinjam;
    }

    public void setLokasiPinjam(String lokasiPinjam) {
        this.lokasiPinjam = lokasiPinjam;
    }

    public String getTanggalPinjam() {
        return this.tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Mobil getMobilPinjam() {
        return this.mobilPinjam;
    }

    public void setMobilPinjam(Mobil mobilPinjam) {
        this.mobilPinjam = mobilPinjam;
    }

    public Pelanggan getPelangganPinjam() {
        return this.pelangganPinjam;
    }

    public void setPelangganPinjam(Pelanggan pelangganPinjam) {
        this.pelangganPinjam = pelangganPinjam;
    }

    public String getStatusPinjam() {
        return this.statusPinjam;
    }

    public void setStatusPinjam(String statusPinjam) {
        this.statusPinjam = statusPinjam;
    }

    public Bus getBusPinjam() {
        return this.busPinjam;
    }

    public void setBusPinjam(Bus busPinjam) {
        this.busPinjam = busPinjam;
    }



    @Override
    public String toString() {
        return "{" +
            " mobils='" + "'" +
            ", pelanggans='"  + "'" +
            ", deposit='" + getDeposit() + "'" +
            ", lokasiPinjam='" + getLokasiPinjam() + "'" +
            ", tanggalPinjam='" + getTanggalPinjam() + "'" +
            ", mobilPinjam='"  + "'" +
            ", pelangganPinjam='" + "'" +
            ", nomorTransaksi='" + getNomorTransaksi() + "'" +
            ", biaya='" + getBiaya() + "'" +
            ", lamaSewa='" + getLamaSewa() + "'" +
            "}";
    }
    
    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk membalikkan textfile ke arraylist
    public static ArrayList<TransaksiPeminjaman> updatePinjam (ArrayList<TransaksiPeminjaman> pinjams) throws FileNotFoundException, IOException, ParseException {
       
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt"))) {
            String s = "";
            while ((s = read.readLine()) != null) {
                String data[] = s.split(",");
                pinjams.add(new TransaksiPeminjaman(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]));
            }
        }
        return pinjams;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk memperbaharui textfile dan arraylist jika ada 1 data yang perlu diganti
    //                       Overloading dengan method diatas karena memiliki nama yang sama dengan parameter berbeda
    public static void updatePinjam (String kodeTransaksi, String status) throws IOException{
        
        String FilePath = "D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt";
        File oldFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt");
        File newFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\temp.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt"))) {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String s = "";
            int i = 0;
            while ((s = br.readLine()) != null) {
                String data[] = s.split(",");
                if (i == 0) {
                    if (data[0].equalsIgnoreCase(kodeTransaksi)) {
                        String row = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + ",";
                        row = row + status;
                        pw.print(row);
                    } else {
                        String row = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] ;
                        pw.print(row);
                    }
                } else {
                    if (data[0].equalsIgnoreCase(kodeTransaksi)) {
                        String row = "\n" +  data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + ",";
                        row = row + status;
                        pw.print(row);
                    } else {
                        String row =  "\n" + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] ;
                        pw.print(row);
                    }
                }
                i++;
            }
            br.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(FilePath);
            newFile.renameTo(dump);
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mencetak resi transaksi peminjaman dari kode transaksi
    public static void cetakRecieptPinjam (String kodeTransaksi, ArrayList<TransaksiPeminjaman> pinjams) throws ParseException {
        
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kodeTransaksi)) {
                System.out.println("Kelompok 4 Rental");
                System.out.println("---------------------");
                System.out.println("Transaksi " + kodeTransaksi);
                if (pinjam.getMobilPinjam() != null) {
                    System.out.println("Sewa mobil " + pinjam.getMobilPinjam().getNamaTransport() + " " + pinjam.getMobilPinjam().getPlatTransportasi());
                    System.out.println("\t\tRp" + pinjam.getMobilPinjam().getHargaSewa() + " x " + pinjam.getLamaSewa());
                } else if (pinjam.getBusPinjam() != null) {
                    System.out.println("Sewa bus " + pinjam.getBusPinjam().getNamaTransport() + " " + pinjam.getBusPinjam().getPlatTransportasi());
                    System.out.println("\t\tRp" + pinjam.getBusPinjam().getHargaSewa() + " x " + pinjam.getLamaSewa());
                }
                System.out.println("Deposit");
                System.out.println("\t\tRp" + pinjam.getDeposit());
                System.out.println("---------------------");
                System.out.println("Total : " + pinjam.getBiaya());
                System.out.println("Peminjaman atas nama " + pinjam.getPelangganPinjam().getNamaPelanggan());
                System.out.println("Harap dikembalikan sebelum " + util.addToDate(pinjam.getTanggalPinjam(), pinjam.getLamaSewa()));
                break;
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikan satu transaksi dari sebuah kode transaksi
    public static TransaksiPeminjaman cariTransaksiPinjam (String kode, ArrayList<TransaksiPeminjaman> pinjams){
        
        int i = 0;
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kode)) {
                break;
            }
            i++;
        }
        return pinjams.get(i);
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk menampilkan info terkait transaksi peminjaman hanya dengan kondisi tertentu
    public static void displayAturanPinjam (String equals1, String kode) throws FileNotFoundException, IOException{
        
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt"))) {
            String s = "";
            System.out.println("|Kode Transaksi\t|Kode Transportasi\t|Kode Penumpang\t\t|Tanggal Pinjam\t|");
            while ((s = read.readLine()) != null) {
                // System.out.println(s);
                String data[] = s.split(",");
                String nm = data[1].substring(0,1);
                if (data[8].equalsIgnoreCase(equals1) && nm.equalsIgnoreCase(kode)) {
                    for (int i = 0; i < 8; i++) {
                        if ((i == 1) || (i == 2)) {
                            System.out.print(data[i] + "\t\t\t|"); 
                        } else if (i == 0){
                            System.out.print("|" +data[i] + "\t\t|"); 
                        } else if (i == 4) {
                            System.out.print(data[i] + "\t|"); 
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

}