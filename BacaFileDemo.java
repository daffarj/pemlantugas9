
// ====== JAWABAN NOMOR 6 ======
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BacaFileDemo {
    public static void main(String[] args) {
        // Contoh membaca file yang tidak ada tanpa pengecekan
        contohTanpaPengecekan();
        
        System.out.println("\n--- Dengan pengecekan yang benar ---");
        // Contoh dengan pengecekan yang benar
        contohDenganPengecekan();
    }
    
    public static void contohTanpaPengecekan() {
        try (FileReader reader = new FileReader("file_tidak_ada.txt")) {
            // Kode untuk membaca file
            int karakter = reader.read();
            System.out.println("Karakter pertama: " + (char) karakter);
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: File tidak ditemukan - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("EXCEPTION: Error saat membaca file - " + e.getMessage());
        }
    }
    
    public static void contohDenganPengecekan() {
        String namaFile = "file_tidak_ada.txt";
        File file = new File(namaFile);
        
        // Pengecekan terlebih dahulu
        if (!file.exists()) {
            System.out.println("File tidak ditemukan: " + namaFile);
            return;
        }
        
        if (!file.isFile()) {
            System.out.println("Bukan file: " + namaFile);
            return;
        }
        
        if (!file.canRead()) {
            System.out.println("File tidak dapat dibaca: " + namaFile);
            return;
        }
        
        // Baru mencoba membaca file
        try (FileReader reader = new FileReader(file)) {
            int karakter = reader.read();
            if (karakter != -1) {
                System.out.println("Karakter pertama: " + (char) karakter);
            } else {
                System.out.println("File kosong");
            }
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        }
    }
}

/*
PENJELASAN NOMOR 6:
Jika kita mencoba membaca file yang tidak ada tanpa pengecekan terlebih dahulu:

1. AKAN TERJADI FileNotFoundException
   - Exception ini adalah subclass dari IOException
   - Program akan berhenti jika tidak ditangani dengan try-catch

2. DAMPAK:
   - Program bisa crash jika exception tidak ditangani
   - User experience menjadi buruk
   - Sulit untuk debugging

3. BEST PRACTICE:
   - Selalu cek apakah file exists() sebelum membaca
   - Gunakan try-catch untuk menangani IOException
   - Berikan pesan error yang informatif kepada user
   - Cek juga file.canRead() untuk memastikan file bisa dibaca
*/