/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;

/**
 *
 * @author C-8
 */

   // Interface untuk Kendaraan
interface Kendaraan {
    void info();
}

// Kelas Induk untuk Mobil
class Mobil implements Kendaraan {
    private String merek;
    private String model;

    public Mobil(String merek, String model) {
        this.merek = merek;
        this.model = model;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public void info() {
        System.out.println("Mobil: " + merek + " " + model);
    }
}

// Kelas Anak untuk Mobil Bekas
class MobilBekas extends Mobil {
    private int tahun;
    private double harga;

    public MobilBekas(String merek, String model, int tahun, double harga) {
        super(merek, model);
        this.tahun = tahun;
        this.harga = harga;
    }

    public int getTahun() {
        return tahun;
    }

    public double getHarga() {
        return harga;
    }

    public void info() {
        System.out.println("Mobil Bekas: " + getMerek() + " " + getModel() + " (" + tahun + ")");
    }
}

// Kelas Anak untuk Mobil Baru
class MobilBaru extends Mobil {
    private String garansi;

    public MobilBaru(String merek, String model, String garansi) {
        super(merek, model);
        this.garansi = garansi;
    }

    public String getGaransi() {
        return garansi;
    }

    public void info() {
        System.out.println("Mobil Baru: " + getMerek() + " " + getModel() + " (Garansi: " + garansi + ")");
    }
}

class Penjualan {
    private Mobil mobil;
    private double harga;

    public Penjualan(Mobil mobil, double harga) {
        this.mobil = mobil;
        this.harga = harga;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public double getHarga() {
        return harga;
    }

    public void info() {
        mobil.info();
        System.out.println("Harga: " + harga);
    }
}

// Kelas untuk Dealer Mobil
class Dealer {
    private String nama;
    private MobilBaru mobilBaru;
    private MobilBekas mobilBekas;
    private ArrayList<Penjualan> penjualanList;

    public Dealer(String nama, MobilBaru mobilBaru, MobilBekas mobilBekas) {
        this.nama = nama;
        this.mobilBaru = mobilBaru;
        this.mobilBekas = mobilBekas;
        this.penjualanList = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }
    public void jualMobil(Mobil mobil, double harga) {
        Penjualan penjualan = new Penjualan(mobil, harga);
        penjualanList.add(penjualan);
    }
     public void tampilkanPenjualan() {
        System.out.println("Daftar Penjualan:");
        for (Penjualan penjualan : penjualanList) {
            penjualan.info();
            System.out.println("--------------------");
        }
    }

    public void info() {
        System.out.println("Dealer: " + nama);
        mobilBaru.info();
        mobilBekas.info();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        MobilBaru mobilBaru = new MobilBaru("Toyota", "Avanza", "3 tahun");
        MobilBekas mobilBekas = new MobilBekas("Honda", "Civic", 2018, 200000000);
        Dealer dealer = new Dealer("Mobilindo", mobilBaru, mobilBekas);
        dealer.info();
        
         // Contoh penjualan mobil
        dealer.jualMobil(mobilBaru, 150000000);
        dealer.jualMobil(mobilBekas, 180000000);

        // Menampilkan daftar penjualan
        dealer.tampilkanPenjualan();
    }
     }


