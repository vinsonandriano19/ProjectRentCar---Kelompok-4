import java.util.ArrayList;
import java.util.Scanner;

public class App  {
    static ArrayList <Mobil> mobils = new ArrayList <>();
    static ArrayList <TransaksiPeminjaman> pinjams = new ArrayList <>();
    static ArrayList <TransaksiPengembalian> kembalis = new ArrayList<>();
    static ArrayList <Pelanggan> pelanggans = new ArrayList<>();
    static ArrayList <Bus> buss = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        util.updateAll(mobils, pinjams, kembalis, pelanggans);
        String yn = "y";
        do {
            util.clearScreen();
            int pilihan = CetakMenu();
            if (pilihan == 1) {
                Mobil.SewaMobil(pelanggans, mobils, pinjams);
            } else if (pilihan == 2) {
                Mobil.kembaliMobil(pinjams, kembalis);
            } else if (pilihan == 3) {
                Mobil.displayAturanMobil("Tersedia");
            } else if (pilihan == 4) {
                TransaksiPeminjaman.displayAturanPinjam("Meminjam","m");
            } else if (pilihan == 5) {
                Mobil.DaftarMobil(mobils);
            } else if (pilihan == 6) {
                break;
            } else {
                throw new Exception("Harus masukkan nilai \"1\" sampai \"6\"");
            }
            System.out.print("Apakah anda ingin melakukan transaksi lainnya? (y/n) : ");
            yn = input.next();
        } while (yn.equalsIgnoreCase("y"));
    }

    public static int CetakMenu () {
        System.out.println("Menu Rental Mobil");
        System.out.println("-----------------");
        System.out.println("1. Sewa Mobil");
        System.out.println("2. Kembali Mobil");
        System.out.println("3. Cetak kendaraan yang tersedia");
        System.out.println("4. Cetak transaksi berlangsung");
        System.out.println("5. Daftar Mobil Baru");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan anda : ");
        int pilihan = input.nextInt();
        return pilihan;
    }


}