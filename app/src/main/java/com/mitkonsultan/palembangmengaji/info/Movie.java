package com.mitkonsultan.palembangmengaji.info;

import java.util.ArrayList;

public class Movie {
	private String title, thumbnailUrl, deskripsi, tanggal;
	private int year;
	private double rating;
	private ArrayList<String> genre;

	public Movie() {
	}

	public Movie(String title,String deskripsi,String tanggal, String thumbnailUrl, int year, double rating,
                 ArrayList<String> genre) {
		this.title = title;
		this.deskripsi = deskripsi;
		this.tanggal = tanggal;
		this.thumbnailUrl = thumbnailUrl;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

}
