package com.mitkonsultan.palembangmengaji.lokasi;

/**
 * Created by ajie on 29/09/17.
 */

public class Lokasi {

    private int gambar;
    private String nama;
    private String jalan;


    public Lokasi(int gambar, String nama,  String jalan) {
        this.gambar = gambar;
        this.nama = nama;
        this.jalan = jalan;

    }

    public int getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getJalan() {
        return jalan;
    }

}
