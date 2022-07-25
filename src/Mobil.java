import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


// Merupakan inheritance dari Mobil
public class Mobil extends Transportasi{
    // atribut
    private String jenisTransmisi;

    static Scanner input = new Scanner(System.in);

    // constructors
    public Mobil() {
    }

    public Mobil(String kodeMobil, String namaMobil, String jenisTransmisi, String PlatTransportasi, int JumlahPenumpang, String StatusMobil, int HargaSewa) {
        this.kodeTransport = kodeMobil;
        this.namaTransport = namaMobil;
        this.jenisTransmisi = jenisTransmisi;
        this.PlatTransportasi = PlatTransportasi;
        this.JumlahPenumpang = JumlahPenumpang;
        this.StatusTransport = StatusMobil;
        this.HargaSewa = HargaSewa;
    }

    // getter setter
    public int getJumlahPenumpang() {
        return this.JumlahPenumpang;
    }

    public void setJumlahPenumpang(int JumlahPenumpang) {
        this.JumlahPenumpang = JumlahPenumpang;
    }

    public String getJenisTransmisi() {
        return this.jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk membalikkan textfile ke arraylist
    public static ArrayList<Mobil> updateMobil (ArrayList<Mobil> mobil) throws FileNotFoundException, IOException {

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            String s = "";
            while ((s = read.readLine()) != null) {
                String data[] = s.split(",");
                mobil.add(new Mobil(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6])));
            }
        }
        return mobil;

    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk memperbaharui textfile dan arraylist jika ada 1 data yang perlu diganti
    //                       Overloading dengan method diatas karena memiliki nama yang sama dengan parameter berbeda
    public static void updateMobil (String kodeMobil, String status) throws IOException{
        
        String FilePath = "D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt";
        File oldFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt");
        File newFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\temp.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String s = "";
            int i = 0;
            while ((s = br.readLine()) != null) {
                String data[] = s.split(",");
                if (i == 0) {
                    if (data[0].equalsIgnoreCase(kodeMobil)) {
                        String row = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," ;
                        row = row + status + "," + data[6];
                        pw.print(row);
                    } else {
                        String row =  data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6];
                        pw.print(row);
                    }
                } else {
                    if (data[0].equalsIgnoreCase(kodeMobil)) {
                        String row = "\n" + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," ;
                        row = row + status + "," + data[6];
                        pw.print(row);
                    } else {
                        String row =  "\n" + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6];
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
    // Deskripsi singkat   : berfungsi untuk menampilan data-data mobil tetapi dengan kondisi tertentu
    public static void displayAturanMobil (String equals) throws FileNotFoundException, IOException{

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            String s = "";
            System.out.println("|Kode\t|Jenis\t|Transmisi\t|Penumpang\t|Harga\t|");
            while ((s = read.readLine()) != null) {
                // System.out.println(s);
                String data[] = s.split(",");
                
                if (data[5].equalsIgnoreCase(equals)) {
                    for (int i = 0; i < 7; i++) {
                        if ((i == 1) || (i == 6)) {
                            System.out.print(data[i] + "\t|"); 
                        } else if (i == 0){
                            System.out.print("|" +data[i] + "\t|"); 
                        } else if ((i==4) || (i==2) ){
                            System.out.print(data[i] + "\t\t|"); 
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mendaftarkan mobil baru yang akan dimasukkan ke arraylist dan textfile
    public static void DaftarMobil (ArrayList<Mobil> mobils) throws Exception {

        System.out.println("Daftar Mobil Baru");
                System.out.println("-----------------");
                System.out.print("Nama mobil : ");
                String namaMobil = input.next();
                System.out.print("Masukkan jumlah penumpang : ");
                int penumpang = input.nextInt();
                System.out.print("Masukkan harga sewa : ");
                int harga = input.nextInt();
                System.out.println("Jenis Transmisi");
                System.out.println("1. Matic");
                System.out.println("2. Manual");
                System.out.print("Masukkan 1/2 : ");
                int pilihanTransmisi = input.nextInt();
                String Transmisi = "";
                if (pilihanTransmisi == 1) {
                    Transmisi = "Matic";
                } else if (pilihanTransmisi == 2) {
                    Transmisi = "Manual";
                } else {
                    throw new Exception("Harus masukkan nilai \"1\" atau \"2\"");
                }
                System.out.print("Masukkan plat transportasi : ");
                String plat1 = input.next();
                String plat2 = input.next();
                String plat3 = input.next();
                String plat = plat1 + " " + plat2 + " " + plat3;

                String kodeMobil = "M0" + Integer.toString(mobils.size()+1);

                //masukkan data pelanggan ke ArrayList
                mobils.add(new Mobil(kodeMobil, namaMobil, Transmisi, plat, penumpang, "Tersedia", harga));
                //masukkan data pelanggan ke file
                try (FileWriter pwMobil = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt", true)) {
                    pwMobil.append("\n" + kodeMobil + "," + namaMobil + "," + Transmisi + "," + plat + "," + penumpang + "," + "Tersedia" + "," + harga);
                }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk menyewa mobil yang kemudian status mobilnya akan diupdate
    //                       serta menambah transaksi peminjaman dan pelanggan
    public static void SewaMobil (ArrayList<Mobil> mobils, ArrayList<TransaksiPeminjaman> pinjams, ArrayList<Pelanggan> pelanggans) throws Exception {
        
        String tanggalPinjam = util.inputTanggal("peminjaman");
        int durasi = util.inputDurasi("peminjaman");
        String lokasiPinjam = util.inputLokasi("peminjaman");
        util.clearScreen();

        //print all cars dgn status tersedia
        Mobil.displayAturanMobil( "Tersedia");
        //input kode mobil yang disewa
        System.out.print("Masukkan kode mobil yang ingin disewakan : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        // util.clearScreen();
        //cetak detail mobil yang kodenya sama dengan inputan
        for (Mobil mobil : mobils) {
            if (mobil.getKodeTransport().equalsIgnoreCase(kodeInput) && mobil.getStatusTransport().equalsIgnoreCase("Tersedia")) {
                System.out.println("Kode Mobil : " + mobil.getKodeTransport());
                System.out.println("Nama Mobil : " + mobil.getNamaTransport());
                System.out.println("Plat Mobil : " + mobil.getPlatTransportasi());
                System.out.println("Harga Sewa per Hari : Rp" + mobil.getHargaSewa());
                int deposit = mobil.getHargaSewa()/10;
                System.out.println("Harga Deposito : Rp" + deposit);
                System.out.println("-----------------------------------");
                int hargaTotal =  mobil.getHargaSewa()*durasi + deposit;
                System.out.println("Harga total : Rp" + hargaTotal);
                System.out.print("Apakah anda yakin?(y/n) : ");
                String pilyakin = input.next();

                //jika yakin input data pelanggan
                if (pilyakin.equalsIgnoreCase("y")) {
                    util.clearScreen();
                    System.out.println("Masukkan detail pelanggan");
                    System.out.println("-------------------------");
                    System.out.print("Nama Pelanggan : ");
                    String namaPelanggan = input.next();
                    System.out.print("Nomor Telepon : ");
                    String noTelp = input.next();
                    System.out.print("Umur : ");
                    int umurPelanggan = input.nextInt();
                    if (umurPelanggan < 18) {
                        throw new Exception("Umur pelanggan tidak mencukupi");
                    }
                    System.out.print("Email : ");
                    String emailPelanggan = input.next();

                    String kodePelanggan = "P0" + Integer.toString(pelanggans.size()+1);
                    String kodePinjam = "T0" + Integer.toString(pinjams.size()+1);

                    //masukkan data pelanggan ke ArrayList
                    pelanggans.add(new Pelanggan(kodePelanggan, namaPelanggan, noTelp, umurPelanggan, emailPelanggan, "meminjam"));
                    //masukkan data pelanggan ke file
                    try (FileWriter pwPelanggan = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\pelanggan.txt", true)) {
                        pwPelanggan.append("\n" + kodePelanggan + "," + namaPelanggan + "," + noTelp + "," + umurPelanggan + "," + emailPelanggan + "," + "meminjam");
                    }

                    //masukkan data pinjam ke ArrayList
                    pinjams.add(new TransaksiPeminjaman(kodePinjam, kodeInput, kodePelanggan, lokasiPinjam, tanggalPinjam, deposit, hargaTotal, durasi, "Meminjam"));
                    //masukkan data pinjam ke file
                    try (FileWriter pwPinjam = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\peminjaman.txt", true)) {
                        pwPinjam.append( "\n" +kodePinjam + "," + kodeInput + "," + kodePelanggan + "," + lokasiPinjam + "," + tanggalPinjam + "," + deposit + "," + hargaTotal + "," + durasi + ",Meminjam");
                    }
                    Mobil.updateMobil(kodeInput, "Dipinjam");

                    //cetak reciept
                    util.clearScreen();
                    TransaksiPeminjaman.cetakRecieptPinjam(kodePinjam,pinjams);
                }
                break;
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikkan mobil yang disewa yang kemudian status mobilnya diupdate
    //                       serta transaksi peminjaman, transaksi pengembalian, dan pelanggan juga akan diupdate
    public static void kembaliMobil (ArrayList<Mobil> mobils, ArrayList<TransaksiPeminjaman> pinjams, ArrayList<Pelanggan> pelanggans, ArrayList<TransaksiPengembalian> kembalis) throws FileNotFoundException, IOException, ParseException{

        TransaksiPeminjaman.displayAturanPinjam ("Meminjam", "m");
        //masukkan nomor peminjaman yang mau dikembalikan
        System.out.print("Masukkan kode transaksi : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        util.clearScreen();
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kodeInput) && pinjam.getStatusPinjam().equalsIgnoreCase("Meminjam")) {
                System.out.println("Nomor Transaksi : " + pinjam.getNomorTransaksi());
                System.out.println("Nama Mobil : " + pinjam.getMobilPinjam().getNamaTransport());
                System.out.println("Plat Mobil : " + pinjam.getMobilPinjam().getPlatTransportasi());
                System.out.println("Peminjam : " + pinjam.getPelangganPinjam().getNamaPelanggan());
                System.out.println("-----------------------");
                String tanggalKembali = util.inputTanggal("pengembalian");
                String lokasiKembali = util.inputLokasi("pengembalian");

                String tanggalKembaliSeharusnya = util.addToDate(pinjam.getTanggalPinjam(), pinjam.getLamaSewa());
                int dendaHari = 0;
                int bedaHari;
                if (tanggalKembali.equalsIgnoreCase(tanggalKembaliSeharusnya)) {
                    System.out.println("Mobil dikembalikan tepat waktu");
                    dendaHari += 0;
                } else {
                    if ((bedaHari = util.getDifferenceDays(tanggalKembali, tanggalKembaliSeharusnya)) > 0) {
                        System.out.printf("Mobil dikembalikan %d hari terlambat\n", bedaHari);
                        dendaHari = bedaHari * 50000;
                    } else {
                        System.out.println("Mobil dikembalikan lebih awal");
                        dendaHari += 0;
                    }
                }
                //cek mobil from class mobil
                int dendaCek = Mobil.cekTransport() * 50000;
                //hitung denda total
                int totalDenda = dendaHari + dendaCek - pinjam.getDeposit();

                TransaksiPeminjaman peminjaman = TransaksiPeminjaman.cariTransaksiPinjam(kodeInput, pinjams);
                Pelanggan.updatePelanggan(peminjaman.getPelangganPinjam().getKodePelanggan(), "lunas");
                Mobil.updateMobil(peminjaman.getMobilPinjam().getKodeTransport(), "Tersedia");
                TransaksiPeminjaman.updatePinjam(kodeInput, "Berhasil");

                //masukkan data kembali ke ArrayList
                kembalis.add(new TransaksiPengembalian(kodeInput, lokasiKembali, tanggalKembali, totalDenda));
                //masukkan data kembali ke file
                try (FileWriter pwKembali = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\pengembalian.txt", true)) {
                    pwKembali.append("\n" + kodeInput + "," + lokasiKembali + "," + tanggalKembali + "," + totalDenda);
                }
                util.clearScreen();
                TransaksiPengembalian.cetakRecieptKembali(kodeInput, kembalis, pinjams);
                break;
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk menampilkan data-data mobil berdasarkan dari harga yang terendah
    //                       sampai yang tertinggi menggunakan insertion sort dan merupakan OverRide method dari 
    //                       class transportasi
    public static void displayAturanMobilAsc (String equals) throws FileNotFoundException, IOException{

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            String s = "";
            ArrayList <Mobil> asc = new ArrayList<>();
            while ((s = read.readLine()) != null) {
                
                String data[] = s.split(",");
                
                if (data[5].equalsIgnoreCase(equals)) {
                    asc.add (new Mobil(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6])));
                }
            }
            for (int i = 1; i < asc.size(); ++i) {
                Mobil obj = new Mobil();
                obj = asc.get(i);
                int j = i-1;
                while (j>=0 && obj.getHargaSewa() < asc.get(j).getHargaSewa()){
                    asc.set(j+1, asc.get(j));
                    j--;
                }
                asc.set(j+1, obj);
                
            }

            System.out.println("|Kode\t|Jenis\t\t|Transmisi\t|Penumpang\t|Harga\t\t|");
            for (Mobil mobil : asc) {
                System.out.println(mobil);
            }
        }
    }

    @Override
    public String toString() {
        return "|" +  getKodeTransport() + "\t|"
        + getNamaTransport() + "\t\t|" 
        + getJenisTransmisi() + "\t\t|"
        + getJumlahPenumpang() + "\t\t|"
        + getHargaSewa() + "\t\t|";
    }

}