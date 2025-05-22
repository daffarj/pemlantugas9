// ====== JAWABAN NOMOR 3 ======
import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {
        // Contoh: tampilkan file di direktori saat ini
        String direktori = "."; // atau ganti dengan path direktori yang diinginkan
        tampilkanDaftarFile(direktori);
    }
    
    public static void tampilkanDaftarFile(String pathDirektori) {
        File direktori = new File(pathDirektori);
        
        if (!direktori.exists()) {
            System.out.println("Direktori tidak ditemukan: " + pathDirektori);
            return;
        }
        
        if (!direktori.isDirectory()) {
            System.out.println(pathDirektori + " bukan direktori");
            return;
        }
        
        // Menggunakan listFiles() untuk mendapatkan array File
        File[] daftarFile = direktori.listFiles();
        
        if (daftarFile == null || daftarFile.length == 0) {
            System.out.println("Direktori kosong atau tidak dapat diakses");
            return;
        }
        
        System.out.println("Daftar file dalam direktori " + pathDirektori + ":");
        for (File file : daftarFile) {
            if (file.isFile()) { // hanya tampilkan file, bukan subdirektori
                System.out.println("- " + file.getName());
            }
        }
        
        // Alternatif menggunakan list()
        System.out.println("\n--- Alternatif menggunakan list() ---");
        String[] namaFile = direktori.list();
        if (namaFile != null) {
            for (String nama : namaFile) {
                File item = new File(direktori, nama);
                if (item.isFile()) {
                    System.out.println("- " + nama);
                }
            }
        }
    }
}
