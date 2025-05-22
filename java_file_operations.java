// ====== JAWABAN NOMOR 1 ======
/*
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
*/



