## 👤 Identitas Mahasiswa

<table>
  <tr>
    <td><b>Nama</b></td>
    <td>Az-Zahra Imsawati Sugianto</td>
  </tr>
  <tr>
    <td><b>NIM</b></td>
    <td>2509116062</td>
  </tr>
  <tr>
    <td><b>Mata Kuliah</b></td>
    <td>Pemrograman Berorientasi Objek</td>
  </tr>
</table>

---

# 🚗 Sistem Manajemen Parkir Kendaraan

Program Sistem Manajemen Parkir Kendaraan merupakan program berbasis Command Line Interface (CLI) yang dibuat menggunakan bahasa pemrograman Java. Program ini digunakan untuk menerima data kendaraan, menghitung durasi parkir, serta menentukan biaya parkir berdasarkan jenis kendaraan dan lama waktu parkir.

Program ini menerapkan konsep Object Oriented Programming (OOP), yaitu **Inheritance, Polymorphism (Method Overriding), Condition (If-Else), dan Looping**.

---

## Deskripsi Studi Kasus

Tema yang dipilih adalah Sistem Manajemen Parkir Kendaraan. Program ini digunakan untuk menerima data dan menghitung biaya parkir berdasarkan jenis kendaraan dan lama waktu parkir. Pengguna dapat memilih dua jenis kendaraan, yaitu Mobil atau Motor. Setelah memilih jenis kendaraan, pengguna memasukkan:

- Nomor plat kendaraan
- Jam masuk
- Menit masuk
- Jam keluar
- Menit keluar

Program kemudian menghitung durasi parkir dan total biaya parkir secara otomatis.

Tarif parkir yang digunakan:

| Jenis Kendaraan | Tarif |
|---|---:|
| Mobil | Rp5.000/jam |
| Motor | Rp2.000/jam |

Apabila durasi parkir memiliki sisa menit, perhitungan biaya akan dibulatkan ke jam berikutnya. Contohnya, durasi parkir 1 jam 45 menit dihitung menjadi 2 jam untuk perhitungan biaya.

Setelah hasil perhitungan ditampilkan, pengguna dapat memilih untuk menghitung parkir kendaraan berikutnya atau mengakhiri program.

---

## Struktur Project

```text
SistemParkir
│
├── Source Packages
│   ├── com.mycompany.sistemparkir
│   │   └── SistemParkir.java
│   │
│   └── model
│       ├── Kendaraan.java
│       ├── Mobil.java
│       └── Motor.java
│
├── Test Packages
├── Dependencies
├── Java Dependencies
└── Project Files
```

---

## Hierarki Class

Program terdiri dari empat class utama:

<img width="1133" height="1388" alt="image" src="https://github.com/user-attachments/assets/8993a448-3cfa-446e-9558-bd0280f5eb17" />

### Penjelasan Class

**1. Kendaraan**

Class `Kendaraan` berperan sebagai superclass. Class ini menyimpan data umum kendaraan seperti nomor plat, waktu masuk, dan waktu keluar.

Class ini juga memiliki method:

- `hitungDurasiMenit()` untuk menghitung lama parkir dalam menit.
- `hitungBiaya()` sebagai method yang akan di-override oleh subclass.
- `tampilkanData()` untuk menampilkan data kendaraan dan durasi parkir.

**2. Mobil**

Class `Mobil` merupakan subclass dari `Kendaraan`. Class ini memiliki tarif parkir sebesar Rp5.000 per jam dan method `hitungBiaya()` untuk menghitung biaya parkir mobil.

**3. Motor**

Class `Motor` merupakan subclass dari `Kendaraan`. Class ini memiliki tarif parkir sebesar Rp2.000 per jam dan method `hitungBiaya()` untuk menghitung biaya parkir motor.

**4. SistemParkir**

Class `SistemParkir` merupakan main class yang digunakan untuk menjalankan program. Class ini menerima input pengguna menggunakan `Scanner`, kemudian membuat objek `Mobil` atau `Motor` sesuai pilihan pengguna. Class ini juga menjalankan perulangan agar pengguna dapat melakukan perhitungan parkir kembali.

---

## ⚙️ Alur Program

<img width="1627" height="967" alt="image" src="https://github.com/user-attachments/assets/2cd65b60-8598-44bf-b15c-d485ddf2f0fd" />

Jika pengguna memilih **1**, program akan membuat objek dari class `Mobil`.

Jika pengguna memilih **2**, program akan membuat objek dari class `Motor`.

Setelah hasil perhitungan ditampilkan, program memberikan pilihan untuk menghitung parkir kembali. Jika pengguna memilih **1 (Ya)**, program kembali ke proses awal. Jika memilih **2 (Tidak)**, program selesai.

---

## Penerapan Inheritance

Konsep **inheritance** diterapkan dengan menjadikan class `Kendaraan` sebagai superclass, sedangkan class `Mobil` dan `Motor` sebagai subclass.

### Class Mobil

```java
public class Mobil extends Kendaraan {
```

### Class Motor

```java
public class Motor extends Kendaraan {
```

Penggunaan keyword `extends` menunjukkan bahwa class `Mobil` dan `Motor` mewarisi atribut dan method yang terdapat pada class `Kendaraan`.

Constructor pada kedua subclass juga menggunakan `super()`:

```java
super(nomorPlat, jamMasuk, menitMasuk, jamKeluar, menitKeluar);
```

`super()` digunakan untuk memanggil constructor milik superclass `Kendaraan`. Dengan inheritance, atribut dan method yang sama tidak perlu ditulis kembali pada setiap subclass.

---

## Penerapan Polymorphism

Konsep **polymorphism** diterapkan menggunakan **Method Overriding** pada method `hitungBiaya()`.

Method `hitungBiaya()` terdapat pada superclass `Kendaraan`:

```java
public int hitungBiaya() {
    return 0;
}
```

Method tersebut kemudian di-override pada class `Mobil` dan `Motor`.

### Class Mobil

```java
@Override
public int hitungBiaya() {
    int durasiMenit = hitungDurasiMenit();
    int jumlahJam = durasiMenit / 60;

    if (durasiMenit % 60 > 0) {
        jumlahJam++;
    }

    return jumlahJam * tarifPerJam;
}
```

### Class Motor

```java
@Override
public int hitungBiaya() {
    int durasiMenit = hitungDurasiMenit();
    int jumlahJam = durasiMenit / 60;

    if (durasiMenit % 60 > 0) {
        jumlahJam++;
    }

    return jumlahJam * tarifPerJam;
}
```

Method `hitungBiaya()` memiliki nama yang sama, tetapi hasil perhitungannya berbeda karena class `Mobil` dan `Motor` memiliki tarif parkir yang berbeda.

---

## Penerapan Condition (If-Else)

Konsep **condition** digunakan untuk menentukan proses berdasarkan pilihan pengguna.

Pada class `SistemParkir`, kondisi digunakan untuk menentukan jenis kendaraan yang dipilih:

```java
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
```

Condition juga digunakan dalam perhitungan biaya parkir:

```java
if (durasiMenit % 60 > 0) {
    jumlahJam++;
}
```

Jika durasi parkir memiliki sisa menit, jumlah jam akan ditambah satu sehingga biaya parkir dibulatkan ke jam berikutnya.

---

## Penerapan Looping

Konsep **looping** diterapkan menggunakan perulangan `do-while` pada class `SistemParkir`.

```java
do {

    // Proses input dan perhitungan parkir

    System.out.println("Hitung parkir lagi?");
    System.out.println("1. Ya");
    System.out.println("2. Tidak");
    System.out.print("Pilihan : ");
    ulang = input.nextInt();

} while (ulang == 1);
```

Looping digunakan agar pengguna dapat melakukan perhitungan parkir untuk kendaraan berikutnya tanpa harus menjalankan ulang program.

Jika pengguna memilih **1 (Ya)**, program akan kembali ke proses awal. Jika pengguna memilih **2 (Tidak)**, perulangan berhenti dan program selesai.

---

## 📷 Screenshot Running Program

### Tampilan Menu Utama

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/3f5527f7-9dce-46fc-a242-c9332cf8cd07"
    width="218"
    alt="Menu Pilihan Jenis Kendaraan">
</p>

Program menampilkan menu utama Sistem Manajemen Parkir Kendaraan yang berisi pilihan jenis kendaraan, yaitu **1. Mobil** dan **2. Motor**. Pengguna memilih jenis kendaraan yang akan dihitung biaya parkirnya dengan memasukkan nomor pilihan.

### 🚗 Running Program Mobil

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/f3e6ff18-c4a8-471c-88ef-764b3fff5915"
    width="300"
    alt="Tampilan Input Data Kendaraan Mobil">
</p>

Program menampilkan pilihan jenis kendaraan, yaitu Mobil dan Motor. Pengguna kemudian memasukkan nomor plat serta waktu masuk dan keluar yang digunakan untuk menghitung durasi parkir.

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/12c7904d-4e85-420e-9d42-8a8141d0fc70"
    width="300"
    alt="Tampilan Hasil Perhitungan Parkir Mobil">
</p>

Program menampilkan hasil perhitungan berupa jenis kendaraan, nomor plat, waktu masuk dan keluar, durasi parkir, tarif per jam, serta total biaya. Pada contoh tersebut, Mobil parkir selama 1 jam 30 menit dan dikenakan biaya sebesar Rp10.000.

---

### 🏍️ Running Program Motor

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/73fcff76-a244-46be-9e05-d42e2b2fd88f"
    width="300"
    alt="Tampilan Input Data Kendaraan Motor">
</p>

Program menampilkan pilihan jenis kendaraan dan pengguna memilih 2 (Motor). Pengguna kemudian memasukkan nomor plat serta waktu masuk dan keluar yang digunakan untuk menghitung durasi parkir.

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/946b757d-298f-4779-823f-0d7089a96493"
    width="300"
    alt="Tampilan Hasil Perhitungan Parkir Motor">
</p>

Program menampilkan hasil perhitungan berupa jenis kendaraan, nomor plat, waktu masuk dan keluar, durasi parkir, tarif per jam, serta total biaya. Pada contoh tersebut, Motor parkir selama 1 jam 45 menit dan dikenakan biaya sebesar Rp4.000.

---

### Running Looping Program

<p align="center">
  <img 
    src="https://github.com/user-attachments/assets/a223a683-a28b-43a6-b3c3-482b92a70d6f"
    width="300"
    alt="Tampilan Looping Program">
</p>

Setelah hasil perhitungan parkir ditampilkan, program memberikan pilihan Hitung parkir lagi?. Jika pengguna memilih **1 (Ya)**, program kembali menampilkan menu parkir sehingga pengguna dapat melakukan perhitungan kendaraan berikutnya. Jika memilih **2 (Tidak)**, program berhenti.

---
