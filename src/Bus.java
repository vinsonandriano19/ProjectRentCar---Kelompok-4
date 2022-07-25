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
public class Bus extends Transportasi{

    
    static Scanner input = new Scanner(System.in);
    
    // constructors
    public Bus() {
    }

    public String getNamaBus() {
        return this.namaTransport;
    }

    public String getKodeBus() {
        return this.kodeTransport;
    }

    public void setKodeBus(String kodeBus) {
        this.kodeTransport = kodeBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaTransport = namaBus;
    }

    public Bus(String kodeBus, String namaBus,String PlatTransportasi,int JumlahPenumpang,String StatusBus, int HargaSewa) {
        this.kodeTransport = kodeBus;
        this.namaTransport = namaBus;
        this.PlatTransportasi = PlatTransportasi;
        this.JumlahPenumpang = JumlahPenumpang;
        this.StatusTransport = StatusBus;
        this.HargaSewa = HargaSewa;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk membalikkan textfile ke arraylist
    public static ArrayList<Bus> updateBus (ArrayList<Bus> buss) throws FileNotFoundException, IOException {

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            String s = "";
            while ((s = read.readLine()) != null) {
                String data[] = s.split(",");
                buss.add(new Bus(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5])));
            }
        }
        return buss;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk memperbaharui textfile dan arraylist jika ada 1 data yang perlu diganti
    //                       Overloading dengan method diatas karena memiliki nama yang sama dengan parameter berbeda
    public static void updateBus (String kodeBus, String status) throws IOException{

        String FilePath = "D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt";
        File oldFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt");
        File newFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\temp.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String s = "";
            int i = 0;
            while ((s = br.readLine()) != null) {
                String data[] = s.split(",");
                if (i == 0) {
                    if (data[0].equalsIgnoreCase(kodeBus)) {
                        String row = data[0] + "," + data[1] + "," + data[2] + ",";
                        row = row + status + "," + data[4];
                        pw.print(row);
                    } else {
                        String row =  data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4];
                        pw.print(row);
                    }
                } else {
                    if (data[0].equalsIgnoreCase(kodeBus)) {
                        String row = "\n" +  data[0] + "," + data[1] + "," + data[2] + ",";
                        row = row + status + "," + data[4];
                        pw.print(row);
                    } else {
                        String row =  "\n" + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4];
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
    // Deskripsi singkat   : berfungsi untuk menampilan data-data bus tetapi dengan kondisi tertentu
    public static void displayAturanBus (String equals) throws FileNotFoundException, IOException{

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            String s = "";
            System.out.println("|Kode\t|Jenis\t\t|Penumpang\t|Harga\t|");
            while ((s = read.readLine()) != null) {
                // System.out.println(s);
                String data[] = s.split(",");
                
                if (data[4].equalsIgnoreCase(equals)) {
                    for (int i = 0; i < 6; i++) {
                        if ((i == 1) || (i == 5) || (i == 3)) {
                            System.out.print(data[i] + "\t|"); 
                        } else if (i == 0){
                            System.out.print("|" +data[i] + "\t|"); 
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mendaftarkan bus baru yang akan dimasukkan ke arraylist dan textfile
    public static void DaftarBus (ArrayList<Bus> buss) throws Exception {

        System.out.println("Daftar Bus Baru");
                System.out.println("-----------------");
                System.out.print("Nama bus : ");
                String namaMobil = input.next();
                System.out.print("Masukkan harga sewa : ");
                int harga = input.nextInt();
                System.out.print("Masukkan plat transportasi : ");
                String plat1 = input.next();
                String plat2 = input.next();
                String plat3 = input.next();
                String plat = plat1 + " " + plat2 + " " + plat3;
                System.out.print("Masukkan jumlah penumpang : ");
                int JumlahPenumpang = input.nextInt();
                String kodeMobil = "B0" + Integer.toString(buss.size()+1);

                //masukkan data pelanggan ke ArrayList
                buss.add(new Bus(kodeMobil, namaMobil, plat, JumlahPenumpang, "Tersedia", harga));
                //masukkan data pelanggan ke file
                try (FileWriter pwMobil = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt", true)) {
                    pwMobil.append("\n" + kodeMobil + "," + namaMobil + ","  + plat + ","  +  "Tersedia" + "," + harga);
                }
    }
    
    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk menyewa bus yang kemudian status busnya akan diupdate
    //                       serta menambah transaksi peminjaman dan pelanggan
    public static void SewaBus (ArrayList<Bus> buss, ArrayList<TransaksiPeminjaman> pinjams, ArrayList<Pelanggan> pelanggans) throws Exception {
        
        String tanggalPinjam = util.inputTanggal("peminjaman");
        int durasi = util.inputDurasi("peminjaman");
        String lokasiPinjam = util.inputLokasi("peminjaman");
        util.clearScreen();

        //print all cars dgn status tersedia
        Bus.displayAturanBus( "Tersedia");
        //input kode mobil yang disewa
        System.out.print("Masukkan kode Bus yang ingin disewakan : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        // util.clearScreen();
        //cetak detail mobil yang kodenya sama dengan inputan
        for (Bus bus : buss) {
            if (bus.getKodeBus().equalsIgnoreCase(kodeInput) && bus.getStatusTransport().equalsIgnoreCase("Tersedia")) {
                System.out.println("Kode Bus : " + bus.getKodeBus());
                System.out.println("Nama Bus : " + bus.getNamaBus());
                System.out.println("Plat Bus : " + bus.getPlatTransportasi());
                System.out.println("Harga Sewa per Hari : Rp" + bus.getHargaSewa());
                int deposit = bus.getHargaSewa()/10;
                System.out.println("Harga Deposito : Rp" + deposit);
                System.out.println("-----------------------------------");
                int hargaTotal =  bus.getHargaSewa()*durasi + deposit;
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
    // Deskripsi singkat   : berfungsi untuk mengembalikkan bus yang disewa yang kemudian status busnya diupdate
    //                       serta transaksi peminjaman, transaksi pengembalian, dan pelanggan juga akan diupdate
    public static void kembaliBus (ArrayList<Bus> buss, ArrayList<TransaksiPeminjaman> pinjams, ArrayList<Pelanggan> pelanggans, ArrayList<TransaksiPengembalian> kembalis) throws FileNotFoundException, IOException, ParseException{
        
        TransaksiPeminjaman.displayAturanPinjam ("Meminjam", "b");
        //masukkan nomor peminjaman yang mau dikembalikan
        System.out.print("Masukkan kode transaksi : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        util.clearScreen();
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kodeInput) && pinjam.getStatusPinjam().equalsIgnoreCase("Meminjam")) {
                System.out.println("Nomor Transaksi : " + pinjam.getNomorTransaksi());
                System.out.println("Nama Bus : " + pinjam.getBusPinjam().getNamaTransport());
                System.out.println("Plat Bus : " + pinjam.getBusPinjam().getPlatTransportasi());
                System.out.println("Peminjam : " + pinjam.getPelangganPinjam().getNamaPelanggan());
                System.out.println("-----------------------");
                String tanggalKembali = util.inputTanggal("pengembalian");
                String lokasiKembali = util.inputLokasi("pengembalian");

                String tanggalKembaliSeharusnya = util.addToDate(pinjam.getTanggalPinjam(), pinjam.getLamaSewa());
                int dendaHari = 0;
                int bedaHari;
                if (tanggalKembali.equalsIgnoreCase(tanggalKembaliSeharusnya)) {
                    System.out.println("Bus dikembalikan tepat waktu");
                    dendaHari += 0;
                } else {
                    if ((bedaHari = util.getDifferenceDays(tanggalKembali, tanggalKembaliSeharusnya)) > 0) {
                        System.out.printf("Bus dikembalikan %d hari terlambat\n", bedaHari);
                        dendaHari = bedaHari * 50000;
                    } else {
                        System.out.println("Bus dikembalikan lebih awal");
                        dendaHari += 0;
                    } 
                }
                //cek mobil from class mobil
                int dendaCek = Bus.cekTransport() * 30000;
                //hitung denda total
                int totalDenda = dendaHari + dendaCek - pinjam.getDeposit();

                TransaksiPeminjaman peminjaman = TransaksiPeminjaman.cariTransaksiPinjam(kodeInput, pinjams);
                Pelanggan.updatePelanggan(peminjaman.getPelangganPinjam().getKodePelanggan(), "lunas");
                Bus.updateBus(peminjaman.getBusPinjam().getKodeTransport(), "Tersedia");
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
    // Deskripsi singkat   : berfungsi untuk menampilkan data-data bus berdasarkan dari harga yang terendah
    //                       sampai yang tertinggi menggunakan insertion sort dan merupakan OverRide method dari 
    //                       class transportasi
    public static void displayAturanBusAsc (String equals) throws FileNotFoundException, IOException{
        
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            String s = "";
            ArrayList <Bus> asc = new ArrayList<>();
            while ((s = read.readLine()) != null) {
                
                String data[] = s.split(",");
                
                if (data[4].equalsIgnoreCase(equals)) {
                    asc.add (new Bus(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5])));
                }
            }
            for (int i = 1; i < asc.size(); ++i) {
                Bus obj = new Bus();
                obj = asc.get(i);
                int j = i-1;
                while (j>=0 && obj.getHargaSewa() < asc.get(j).getHargaSewa()){
                    asc.set(j+1, asc.get(j));
                    j--;
                }
                asc.set(j+1, obj);
                
            }

            System.out.println("|Kode\t|Jenis\t\t|Penumpang\t|Harga\t\t|");
            for (Bus bus : asc) {
                System.out.println(bus);
            }
        }
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengecek kondisi bus dan merupakan OverRide method dari class transportasi
    public static int cekTransport (){

        int total = 0;
        int data[] = new int[4];
        System.out.println("Cek Transport");
        System.out.println("---------");
        System.out.println("0 jika terpenuhi, 1 jika tidak");
        System.out.print("Minyak di atas 50% : ");
        data[0] = input.nextInt();
        System.out.print("Mesin jalan lancar : ");
        data[1] = input.nextInt()*2;
        System.out.print("Bodi tidak tergores : ");
        data[2] = input.nextInt()*2;
        for (int i : data) {
            total += i;
        }
        return total;
    }

    @Override
    public String toString() {
        return "|" +  getKodeTransport() + "\t|"
        + getNamaTransport() + "\t|" 
        + getJumlahPenumpang() + "\t\t|"
        + getHargaSewa() + "\t|";
    }
}