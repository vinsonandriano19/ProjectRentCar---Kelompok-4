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

public class Mobil extends Transportasi{

    private String kodeMobil;
    private String namaMobil;
    private String jenisTransmisi;
    static Scanner input = new Scanner(System.in);
    
    public Mobil() {
    }

    public Mobil(String kodeMobil, String namaMobil, String jenisTransmisi) {
        this.kodeMobil = kodeMobil;
        this.namaMobil = namaMobil;
        this.jenisTransmisi = jenisTransmisi;
    }

    public Mobil(String kodeMobil, String namaMobil, String jenisTransmisi, String PlatTransportasi, int JumlahPenumpang, String StatusMobil, int HargaSewa) {
        this.kodeMobil = kodeMobil;
        this.namaMobil = namaMobil;
        this.jenisTransmisi = jenisTransmisi;
        this.PlatTransportasi = PlatTransportasi;
        this.JumlahPenumpang = JumlahPenumpang;
        this.StatusTransportasi = StatusMobil;
        this.HargaSewa = HargaSewa;
    }

    public String getNamaMobil() {
        return this.namaMobil;
    }

    public String getKodeMobil() {
        return this.kodeMobil;
    }

    public void setKodeMobil(String kodeMobil) {
        this.kodeMobil = kodeMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getJenisTransmisi() {
        return this.jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

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

    public static void updateMobil (String kodeMobil, String status) throws IOException{
        String FilePath = "D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt";
        File oldFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt");
        File newFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\temp.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = s.split(",");
                if (data[0].equalsIgnoreCase(kodeMobil)) {
                    String row = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," ;
                    row = row + status + "," + data[6];
                    pw.println(row);
                } else {
                    String row = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6];
                    pw.println(row);
                }
            }
            br.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(FilePath);
            newFile.renameTo(dump);
        }
    }

    public static int cekMobil (){
        int total = 0;
        int data[] = new int[4];
        System.out.println("Cek Mobil");
        System.out.println("---------");
        System.out.println("0 jika terpenuhi, 1 jika tidak");
        System.out.print("Minyak di atas 50% : ");
        data[0] = input.nextInt();
        System.out.print("Mesin jalan lancar : ");
        data[1] = input.nextInt()*3;
        System.out.print("Bodi tidak tergores : ");
        data[2] = input.nextInt()*3;
        System.out.print("Interior bersih : ");
        data[3] = input.nextInt();

        for (int i : data) {
            total += i;
        }
        return total;
    }

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

    public static void SewaMobil (ArrayList<Pelanggan>pelanggans, ArrayList<Mobil>mobils, ArrayList<TransaksiPeminjaman>pinjams) throws Exception {
        
        System.out.println("Masukkan tanggal peminjaman");
        System.out.print("Tanggal (1-31) : ");
        int day = input.nextInt();
        System.out.print("Bulan (1-12): ");
        int month = input.nextInt();
        System.out.print("Tahun : ");
        int year = input.nextInt();
            //gabung jadi 1 string
        String tanggalPinjam = Integer.toString(day) + "/" + Integer.toString(month) + "/" +Integer.toString(year);
        tanggalPinjam = util.changeToDate(tanggalPinjam);

        //input durasi pinjam
        System.out.print("Masukkan durasi peminjaman anda : ");
        int durasi = input.nextInt();

        //input lokasi pinjam
        System.out.print("Masukkan lokasi peminjaman anda : ");
        String lokasiPinjam = input.next();
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
            if (mobil.getKodeMobil().equalsIgnoreCase(kodeInput) && mobil.getStatusTransportasi().equalsIgnoreCase("Tersedia")) {
                System.out.println("Kode Mobil : " + mobil.getKodeMobil());
                System.out.println("Nama Mobil : " + mobil.getNamaMobil());
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
                    try (FileWriter pwPelanggan = new FileWriter("data/pelanggan.txt", true)) {
                        pwPelanggan.append("\n" + kodePelanggan + "," + namaPelanggan + "," + noTelp + "," + umurPelanggan + "," + emailPelanggan + "," + "meminjam");
                    }

                    //masukkan data pinjam ke ArrayList
                    pinjams.add(new TransaksiPeminjaman(kodePinjam, kodeInput, kodePelanggan, lokasiPinjam, tanggalPinjam, deposit, hargaTotal, durasi, "Meminjam"));
                    //masukkan data pinjam ke file
                    try (FileWriter pwPinjam = new FileWriter("data/peminjaman.txt", true)) {
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

    public static void kembaliMobil (ArrayList<TransaksiPeminjaman>pinjams, ArrayList<TransaksiPengembalian>kembalis) throws FileNotFoundException, IOException, ParseException{
        TransaksiPeminjaman.displayAturanPinjam ("Meminjam", "m");
        //masukkan nomor peminjaman yang mau dikembalikan
        System.out.print("Masukkan kode transaksi : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        util.clearScreen();
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kodeInput) && pinjam.getStatusPinjam().equalsIgnoreCase("Meminjam")) {
                System.out.println("Nomor Transaksi : " + pinjam.getNomorTransaksi());
                System.out.println("Nama Mobil : " + pinjam.getMobilPinjam().getNamaMobil());
                System.out.println("Plat Mobil : " + pinjam.getMobilPinjam().getPlatTransportasi());
                System.out.println("Peminjam : " + pinjam.getPelangganPinjam().getNamaPelanggan());
                System.out.println("-----------------------");
                System.out.println("Tanggal Pengembalian");
                System.out.print("Tanggal (1-31) : ");
                int day = input.nextInt();
                System.out.print("Bulan (1-12): ");
                int month = input.nextInt();
                System.out.print("Tahun : ");
                int year = input.nextInt();
                    //gabung jadi 1 string
                String tanggalKembali = Integer.toString(day) + "/" + Integer.toString(month) + "/" +Integer.toString(year);
                System.out.print("Masukkan lokasi pengembalian : ");
                String lokasiKembali = input.next();
                tanggalKembali = util.changeToDate(tanggalKembali);

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
                int dendaCek = Mobil.cekMobil() * 50000;
                //hitung denda total
                int totalDenda = dendaHari + dendaCek - pinjam.getDeposit();

                TransaksiPeminjaman peminjaman = TransaksiPeminjaman.cariTransaksiPinjam(kodeInput, pinjams);
                Pelanggan.updatePelanggan(peminjaman.getPelangganPinjam().getKodePelanggan(), "lunas");
                Mobil.updateMobil(peminjaman.getMobilPinjam().getKodeMobil(), "Tersedia");
                TransaksiPeminjaman.updatePinjam(kodeInput, "Berhasil");

                //masukkan data kembali ke ArrayList
                kembalis.add(new TransaksiPengembalian(kodeInput, lokasiKembali, tanggalKembali, totalDenda));
                //masukkan data kembali ke file
                try (FileWriter pwKembali = new FileWriter("data/pengembalian.txt", true)) {
                    pwKembali.append("\n" + kodeInput + "," + lokasiKembali + "," + tanggalKembali + "," + totalDenda);
                }
                util.clearScreen();
                TransaksiPengembalian.cetakRecieptKembali(kodeInput, kembalis, pinjams);
                break;
            }
        }
    }
}