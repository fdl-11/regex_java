package com.company;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String kata, kalimat, email, regex_email, pw, regex_pw, regex, cek_regex;
        int pil;

        do {
            System.out.println("+--------------------------------------+");
            System.out.println("|        TBO - Ekspresi Reguler        |");
            System.out.println("+--------------------------------------+");
            System.out.println("|    1. Mencari Kata dalam Kalimat     |");
            System.out.println("|    2. Validasi Email                 |");
            System.out.println("|    3. Validasi Password              |");
            System.out.println("|    4. Input Regex Manual             |");
            System.out.println("+--------------------------------------+");
            System.out.print("Masukkan Pilihan : ");
            pil = in.nextInt();
            in.nextLine();

            if(pil == 1){
                System.out.println("\n----------------------------------------\n");
                System.out.println("[ Mencari kata dalam suatu Kalimat ]\n");

                System.out.print("Masukkan Kalimat                 : ");
                kalimat = in.nextLine();
                System.out.print("Masukkan Kata yang ingin dicari  : ");
                kata = in.nextLine();

                Pattern pola = Pattern.compile(kata);
                Matcher cek = pola.matcher(kalimat);

                while (cek.find()){
                    System.out.println("Kata " + cek.group() +
                            " berhasil ditemukan pada index ke-" + cek.start() +
                            " dan berakhir pada index ke-" + cek.end());
                }

                System.out.println("\n----------------------------------------\n");
            } else if(pil == 2){
                System.out.println("\n----------------------------------------\n");
                System.out.println("[ Validasi Email ]\n");

                // Referensi Ekspesi Reguler Email = Video ke-2 materi ke-14
                regex_email = "^([a-zA-Z0-9\\+_\\-]+)(\\.[a-zA-Z0-9\\+_\\-]+)*@([a-zA-Z0-9\\-]+\\.)+[a-z]{2,6}$";
                System.out.print("Masukkan Email  : ");
                email = in.nextLine();

                System.out.println(Pattern.matches(regex_email, email));
                System.out.println("\n----------------------------------------\n");
            } else if(pil == 3){
                System.out.println("\n----------------------------------------\n");
                System.out.println("[ Validasi Password ]");
                System.out.println(">> Password Minimal 8 karakter, maksimal 16 karakter...");
                System.out.println(">> Password harus memiliki minimal satu Huruf Besar, " +
                        "satu Huruf Kecil, satu Angka, dan satu karakter spesial...");
                System.out.println(">> Password tidak boleh mengandung spasi...");

                // Referensi Ekspresi Reguler Password = geeksforgeeks
                regex_pw = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.()_])(?=\\S+$).{8,16}$";
                System.out.print("\nMasukkan Password  : ");
                pw = in.nextLine();

                System.out.println(Pattern.matches(regex_pw, pw));
                System.out.println("\n----------------------------------------\n");
            } else if(pil == 4){
                System.out.println("\n----------------------------------------\n");
                System.out.println("[ Input Ekspresi Reguler Manual ]");
                System.out.print("Masukkan Ekspresi Reguler : ");
                regex = in.nextLine();
                System.out.print("Masukkan inputan          : ");
                cek_regex = in.nextLine();

                //^(\+62|62|0)[0-9]{9,12}$
                System.out.println(Pattern.matches(regex, cek_regex));
                System.out.println("\n----------------------------------------\n");
            } else{
                System.out.println("\nSelamat Tinggal...");
                System.exit(0);
            }
        } while (pil != 5);
    }
}
