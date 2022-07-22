import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus extends Transportasi{

    private String kodeBus;
    private String namaBus;
    static Scanner input = new Scanner(System.in);
    
    public Bus() {
    }

    public Bus(String kodeBus, String namaBus) {
        this.kodeBus = kodeBus;
        this.namaBus = namaBus;
    }

    public Bus(String kodeBus, String namaBus, String PlatTransportasi, int JumlahPenumpang, String StatusBus, int HargaSewa) {
        this.kodeBus = kodeBus;
        this.namaBus = namaBus;
        this.PlatTransportasi = PlatTransportasi;
        this.JumlahPenumpang = JumlahPenumpang;
        this.StatusTransportasi = StatusBus;
        this.HargaSewa = HargaSewa;
    }

    public String getNamaBus() {
        return this.namaBus;
    }

    public String getKodeBus() {
        return this.kodeBus;
    }

    public void setKodeBus(String kodeBus) {
        this.kodeBus = kodeBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaBus = namaBus;
    }

    public static ArrayList<Bus> updateBus (ArrayList<Bus> bus) throws FileNotFoundException, IOException {
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt"))) {
            String s = "";
            while ((s = read.readLine()) != null) {
                String data[] = s.split(",");
                bus.add(new Bus(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5])));
            }
        }
        return bus;
    }

    public static void updateBus (String kodeBus, String status) throws IOException{
        String FilePath = "D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt";
        File oldFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt");
        File newFile = new File ("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\temp.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = s.split(",");
                if (data[0].equalsIgnoreCase(kodeBus)) {
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

    public static int cekBus (){
        int total = 0;
        int data[] = new int[4];
        System.out.println("Cek Bus");
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

    public static void displayAturanBus (String equals) throws FileNotFoundException, IOException{
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\bus.txt"))) {
            String s = "";
            System.out.println("|Kode\t|Jenis\t|Penumpang\t|Harga\t|");
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

    public static void DaftarBus (ArrayList<Bus> buss) throws Exception {
        System.out.println("Daftar Bus Baru");
                System.out.println("-----------------");
                System.out.print("Nama Bus : ");
                String namaBus = input.next();
                System.out.print("Masukkan jumlah penumpang : ");
                int penumpang = input.nextInt();
                System.out.print("Masukkan harga sewa : ");
                int harga = input.nextInt();
                System.out.print("Masukkan plat transportasi : ");
                String plat1 = input.next();
                String plat2 = input.next();
                String plat3 = input.next();
                String plat = plat1 + " " + plat2 + " " + plat3;

                String kodeBus = "M0" + Integer.toString(buss.size()+1);

                //masukkan data pelanggan ke ArrayList
                buss.add(new Bus(kodeBus, namaBus, plat, penumpang, "Tersedia", harga));
                //masukkan data pelanggan ke file
                try (FileWriter pwMobil = new FileWriter("D:\\UPH\\Semester Aksel\\Pemrogrman Berorientasi Objek\\Tugas\\ProjectRentCar 2\\ProjectRentCar\\src\\data\\mobil.txt", true)) {
                    pwMobil.append("\n" + kodeBus + "," + namaBus + "," + plat + "," + penumpang + "," + "Tersedia" + "," + harga);
                }
    }

    public static void SewaMobil (ArrayList<Pelanggan>pelanggans, ArrayList<Bus>buss, ArrayList<TransaksiPeminjaman>pinjams) throws Exception {
        
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
        for (Bus bus : buss) {
            if (bus.getKodeBus().equalsIgnoreCase(kodeInput) && bus.getStatusTransportasi().equalsIgnoreCase("Tersedia")) {
                System.out.println("Kode Mobil : " + bus.getKodeBus());
                System.out.println("Nama Mobil : " + bus.getNamaBus());
                System.out.println("Plat Mobil : " + bus.getPlatTransportasi());
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

    public static void kembaliBus (ArrayList<TransaksiPeminjaman>pinjams, ArrayList<TransaksiPengembalian>kembalis) throws FileNotFoundException, IOException, ParseException{
        TransaksiPeminjaman.displayAturanPinjam ("Meminjam", "m");
        //masukkan nomor peminjaman yang mau dikembalikan
        System.out.print("Masukkan kode transaksi : ");
        String kodeInput = input.next();
        kodeInput = kodeInput.toUpperCase();
        util.clearScreen();
        for (TransaksiPeminjaman pinjam : pinjams) {
            if (pinjam.getNomorTransaksi().equalsIgnoreCase(kodeInput) && pinjam.getStatusPinjam().equalsIgnoreCase("Meminjam")) {
                System.out.println("Nomor Transaksi : " + pinjam.getNomorTransaksi());
                System.out.println("Nama Bus : " + pinjam.getMobilPinjam().getNamaMobil());
                System.out.println("Plat Bus : " + pinjam.getMobilPinjam().getPlatTransportasi());
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
                int dendaCek = Bus.cekBus() * 50000;
                //hitung denda total
                int totalDenda = dendaHari + dendaCek - pinjam.getDeposit();

                TransaksiPeminjaman peminjaman = TransaksiPeminjaman.cariTransaksiPinjam(kodeInput, pinjams);
                Pelanggan.updatePelanggan(peminjaman.getPelangganPinjam().getKodePelanggan(), "lunas");
                Bus.updateBus(peminjaman.getBusPinjam().getKodeBus(), "Tersedia");
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
