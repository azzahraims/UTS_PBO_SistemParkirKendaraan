/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Kendaraan {
    protected String nomorPlat;
    protected int jamMasuk;
    protected int menitMasuk;
    protected int jamKeluar;
    protected int menitKeluar;

    public Kendaraan(String nomorPlat, int jamMasuk, int menitMasuk,
                     int jamKeluar, int menitKeluar) {
        this.nomorPlat = nomorPlat;
        this.jamMasuk = jamMasuk;
        this.menitMasuk = menitMasuk;
        this.jamKeluar = jamKeluar;
        this.menitKeluar = menitKeluar;
    }

    public int hitungDurasiMenit() {
        int waktuMasuk = (jamMasuk * 60) + menitMasuk;
        int waktuKeluar = (jamKeluar * 60) + menitKeluar;

        return waktuKeluar - waktuMasuk;
    }

    // Method ini akan di-override oleh Mobil dan Motor
    public int hitungBiaya() {
        return 0;
    }

    public void tampilkanData() {
        int durasiMenit = hitungDurasiMenit();
        int jam = durasiMenit / 60;
        int menit = durasiMenit % 60;

        System.out.println("Nomor Plat : " + nomorPlat);
        System.out.printf("Waktu Masuk : %02d.%02d%n", jamMasuk, menitMasuk);
        System.out.printf("Waktu Keluar : %02d.%02d%n", jamKeluar, menitKeluar);
        System.out.println("Durasi Parkir : " + jam + " jam " + menit + " menit");
    }
}
