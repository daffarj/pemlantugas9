// ====== JAWABAN NOMOR 2 ======
import java.io.File;
import java.text.DecimalFormat;

public class UkuranFile {
    public static void main(String[] args) {
        // Contoh penggunaan
        String namaFile = "test.txt"; // ganti dengan nama file yang diinginkan
        tampilkanUkuranFile(namaFile);
    }
    
    public static void tampilkanUkuranFile(String namaFile) {
        File file = new File(namaFile);
        
        if (!file.exists()) {
            System.out.println("File tidak ditemukan: " + namaFile);
            return;
        }
        
        long ukuranBytes = file.length();
        DecimalFormat df = new DecimalFormat("#.##");
        
        if (ukuranBytes < 1024 * 1024) { // < 1 MB
            double ukuranKB = ukuranBytes / 1024.0;
            System.out.println("Ukuran file: " + df.format(ukuranKB) + " KB");
        } else { // >= 1 MB
            double ukuranMB = ukuranBytes / (1024.0 * 1024.0);
            System.out.println("Ukuran file: " + df.format(ukuranMB) + " MB");
        }
    }
}
