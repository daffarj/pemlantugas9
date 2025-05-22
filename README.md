# pemlantugas9
## Operation File

**code**
1. Jawaban no 1[java_file_operations.java](java_file_operations.java)
2. Jawaban no 2[UkuranFile.java](UkuranFile.java)
3. Jawaban no 3[DaftarFile.java](DaftarFile.java)
4. Jawaban no 4[HapusDirektori.java](HapusDirektori.java)
5. Jawaban no 5[NomorLima.java](NomorLima.java)
6. Jawaban no 6[BacaFileDemo.java](BacaFileDemo.java)

### Jawaban No 1 

 ====== JAWABAN NOMOR 1 ======

ANALISIS TulisFile1.java:

Ketika parameter FileWriter adalah false (baris 13):
- Setiap kali program dijalankan, file "test.txt" akan ditimpa (overwrite)
- Isi file lama akan hilang dan diganti dengan teks baru
- File hanya berisi teks dari eksekusi terakhir

Ketika parameter diubah menjadi true:
- Teks akan ditambahkan (append) ke akhir file yang sudah ada
- Isi file lama tetap ada, teks baru ditambahkan di belakangnya
- Setiap eksekusi akan menambah isi file, bukan menimpa

Parameter kedua FileWriter menentukan mode append:
- false = overwrite mode
- true = append mode

### Jawaban No 2

Kita buat deklarasi dahulu untuk nama filenya saya tuliskan demonya yaitu `test.txt`.
``` java
 String namaFile = "test.txt"; // ganti dengan nama file yang diinginkan
        tampilkanUkuranFile(namaFile);
```
Lalu kita buat method untuk menampilkan ukuran file tersebut.
``` java
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
```
Dengan cara ini, kita dapat menampilkan ukuran file dalam satuan KB atau MB, tergantung ukuran dalam file tsb. Jika <1 MB maka akan ditampilkan dalam satuan KB, jika >= maka akan ditampilkan dalam satuan MB.
### Jawaban no. 3
Diawal kita mendaklarasikan variabel untuk nama direktori 
```java
// Contoh: tampilkan file di direktori saat ini
        String direktori = "."; // atau ganti dengan path direktori yang diinginkan
        tampilkanDaftarFile(direktori);
```
Lalu kita buat method untuk menampilkan daftar file di direktori tersebut.
```java
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
```
Dengan cara ini, kita dapat menampilkan daftar file di direktori yang ditentukan.
### Jawaban no 4
Diawal sama kita deklarasi variabel untuk direktorinya 
```java
// Contoh penggunaan - HATI-HATI saat testing!
        String namaDirektori = "test_directory"; // ganti dengan nama direktori yang ingin dihapus
        hapusDirektoriBesertaIsi(namaDirektori);
```
Lalu kita buat method hapusDirektoriBesertaIsi() untuk menghapus direktori beserta isinya
```java
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
```
Jangan lupa untuk menambahkan try-catch block untuk menghandle kesalahan yang mungkin terjadi.
### Jawaban no 5

====== JAWABAN NOMOR 5 ======

MASALAH DENGAN STATEMENT: var file = new File("C:\Data\Java\teks.txt");

Yang salah adalah penggunaan backslash (\) dalam string path.
Dalam Java, backslash adalah escape character, sehingga:
- \D akan diinterpretasikan sebagai escape sequence (meskipun tidak valid)
- \J juga akan diinterpretasikan sebagai escape sequence
- \t akan diinterpretasikan sebagai tab character

SOLUSI:
1. Gunakan double backslash (\\):
   var file = new File("C:\\Data\\Java\\teks.txt");

2. Gunakan forward slash (/):
   var file = new File("C:/Data/Java/teks.txt");

3. Gunakan File.separator untuk portabilitas:
   var file = new File("C:" + File.separator + "Data" + File.separator + "Java" + File.separator + "teks.txt");

4. Gunakan Paths (Java 7+):
   Path path = Paths.get("C:", "Data", "Java", "teks.txt");
   File file = path.toFile();

### Jawaban No 6
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

contoh demo ada di file [BacaFileDemo.java](BacaFileDemo.java)
