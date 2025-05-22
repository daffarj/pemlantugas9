
// ====== JAWABAN NOMOR 5 ======
/*
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
*/
