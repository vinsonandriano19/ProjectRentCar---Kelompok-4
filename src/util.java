import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class util {
    static Scanner input = new Scanner(System.in);

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk memperbaiki ketika terjadi penginputan tanggal salah menjadi benar
    public static String changeToDate (String tanggal) throws ParseException{
        
        Calendar cal = Calendar.getInstance();
            //string diubah ke date dan calender
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(date.parse(tanggal));
            //date ubah balek ke string
        tanggal = date.format(cal.getTime());
        return tanggal;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk menambah tanggal dengan durasi dalam satuan hari
    public static String addToDate (String tanggal, int durasi) throws ParseException{
        
        Calendar cal = Calendar.getInstance();
            //string diubah ke date dan calender
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(date.parse(tanggal));
        //nambah tanggal
        cal.add(Calendar.DAY_OF_MONTH, durasi);
            //date ubah balek ke string
        tanggal = date.format(cal.getTime());
        return tanggal;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikan perbedaan 2 tanggal dalam satuan hari
    public static int getDifferenceDays(String date1, String date2) throws ParseException {
        
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
        long diff = d1.getTime() - d2.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengupdate arraylist dari file
    public static void updateAll ( ArrayList <Mobil> mobils,ArrayList <TransaksiPeminjaman> pinjams, ArrayList <TransaksiPengembalian> kembalis, ArrayList <Pelanggan> pelanggans, ArrayList<Bus> buss) throws FileNotFoundException, IOException, ParseException{
        
        mobils.removeAll(mobils);
        Mobil.updateMobil(mobils);
        pelanggans.removeAll(pelanggans);
        Pelanggan.updatePelanggan(pelanggans);
        pinjams.removeAll(pinjams);
        TransaksiPeminjaman.updatePinjam(pinjams);
        kembalis.removeAll(kembalis);
        TransaksiPengembalian.updateKembali(kembalis);
        buss.removeAll(buss);
        Bus.updateBus(buss);
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk membersihkan layar terminal
    public static void clearScreen(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikan inputan tanggal dari user
    public static String inputTanggal (String status) throws ParseException {
        
        //input tanggal pinjam
        System.out.println("Masukkan tanggal " + status.toLowerCase());
        System.out.print("Tanggal (1-31) : ");
        int day = input.nextInt();
        System.out.print("Bulan (1-12): ");
        int month = input.nextInt();
        System.out.print("Tahun : ");
        int year = input.nextInt();
            //gabung jadi 1 string
        String tanggal = Integer.toString(day) + "/" + Integer.toString(month) + "/" +Integer.toString(year);
        tanggal = util.changeToDate(tanggal);
        return tanggal;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikan inputan durasi dari user
    public static int inputDurasi (String status) {
        
        //input durasi pinjam
        System.out.print("Masukkan durasi " + status.toLowerCase() + " anda : ");
        int durasi = input.nextInt();
        return durasi;
    }

    // Nama                : Vinson Andriano
    // NIM                 : 03081210023
    // Deskripsi singkat   : berfungsi untuk mengembalikan inputan lokasi dari user
    public static String inputLokasi (String status ){
       
        //input lokasi pinjam
        System.out.print("Masukkan lokasi " + status + " anda : ");
        String lokasi = input.next();
        return lokasi;
    }
}