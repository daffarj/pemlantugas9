// ====== JAWABAN NOMOR 4 ======
import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {
        // Contoh penggunaan - HATI-HATI saat testing!
        String namaDirektori = "test_directory"; // ganti dengan nama direktori yang ingin dihapus
        hapusDirektoriBesertaIsi(namaDirektori);
    }
    
    public static boolean hapusDirektoriBesertaIsi(String pathDirektori) {
        File direktori = new File(pathDirektori);
        
        if (!direktori.exists()) {
            System.out.println("Direktori tidak ditemukan: " + pathDirektori);
            return false;
        }
        
        if (!direktori.isDirectory()) {
            System.out.println(pathDirektori + " bukan direktori");
            return false;
        }
        
        // Dapatkan semua file dalam direktori
        File[] daftarFile = direktori.listFiles();
        
        if (daftarFile != null) {
            // Hapus semua file dalam direktori
            for (File file : daftarFile) {
                if (file.isFile()) {
                    if (file.delete()) {
                        System.out.println("File dihapus: " + file.getName());
                    } else {
                        System.out.println("Gagal menghapus file: " + file.getName());
                        return false;
                    }
                }
            }
        }
        
        // Hapus direktori setelah semua file dihapus
        if (direktori.delete()) {
            System.out.println("Direktori berhasil dihapus: " + pathDirektori);
            return true;
        } else {
            System.out.println("Gagal menghapus direktori: " + pathDirektori);
            return false;
        }
    }
}
