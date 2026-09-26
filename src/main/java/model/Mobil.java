/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Mobil extends Kendaraan {
    private int tarifPerJam = 5000;

    public Mobil(String nomorPlat, int jamMasuk, int menitMasuk,
                 int jamKeluar, int menitKeluar) {
        super(nomorPlat, jamMasuk, menitMasuk, jamKeluar, menitKeluar);
    }

    @Override
    public int hitungBiaya() {
        int durasiMenit = hitungDurasiMenit();
        int jumlahJam = durasiMenit / 60;

        if (durasiMenit % 60 > 0) {
            jumlahJam++;
        }

        return jumlahJam * tarifPerJam;
    }

    public void tampilkanHasil() {
        System.out.println();
        System.out.println("=== TARIF PARKIR ===");
        System.out.println("Jenis Kendaraan : Mobil");
        tampilkanData();
        System.out.println("Tarif Per Jam : Rp" + tarifPerJam);
        System.out.println("Total Biaya : Rp" + hitungBiaya());
    }
}