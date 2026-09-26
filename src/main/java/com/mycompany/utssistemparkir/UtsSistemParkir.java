/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.utssistemparkir;
import java.util.Scanner;
import model.Mobil;
import model.Motor;

/**
 *
 * @author user
 */
public class UtsSistemParkir {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int ulang;

        do {
            System.out.println("=====================================");
            System.out.println("          PARKIR KENDARAAN");
            System.out.println("=====================================");

            System.out.println("Pilih Jenis Kendaraan:");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1 || pilihan == 2) {

                System.out.print("Nomor Plat : ");
                String nomorPlat = input.nextLine();

                System.out.print("Jam Masuk : ");
                int jamMasuk = input.nextInt();

                System.out.print("Menit Masuk : ");
                int menitMasuk = input.nextInt();

                System.out.print("Jam Keluar : ");
                int jamKeluar = input.nextInt();

                System.out.print("Menit Keluar : ");
                int menitKeluar = input.nextInt();

                if (pilihan == 1) {
                    Mobil mobil = new Mobil(
                            nomorPlat,
                            jamMasuk,
                            menitMasuk,
                            jamKeluar,
                            menitKeluar
                    );

                    mobil.tampilkanHasil();

                } else {
                    Motor motor = new Motor(
                            nomorPlat,
                            jamMasuk,
                            menitMasuk,
                            jamKeluar,
                            menitKeluar
                    );

                    motor.tampilkanHasil();
                }

            } else {
                System.out.println("Pilihan kendaraan tidak tersedia.");
            }

            System.out.println();
            System.out.println("Hitung parkir lagi?");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            System.out.print("Pilihan : ");
            ulang = input.nextInt();

            System.out.println();

        } while (ulang == 1);

        System.out.println("Program selesai. Terima kasih.");

        input.close();
    }
}
