package com.mitkonsultan.palembangmengaji.haridataadapter;

/**
 * Created by ajie on 26/09/17.
 */

import java.util.ArrayList;

public class SeninDataAdapter {

    private String masjid, waktu, pengisi, tema, tanggal, kategori;

    public SeninDataAdapter(String masjid, String waktu, String pengisi, String tema, String tanggal, String kategori) {
        this.masjid = masjid;
        this.waktu = waktu;
        this.pengisi = pengisi;
        this.tema = tema;
        this.tanggal = tanggal;
        this.kategori = kategori;

    }

    public String getMasjid() {
        return masjid;
    }
    public String getWaktu() {
        return waktu;
    }
    public String getPengisi() {
        return pengisi;
    }
    public String getTema() {return tema;}
    public String getTanggal() {return tanggal;}
    public String getKategori() {return kategori;}



}
