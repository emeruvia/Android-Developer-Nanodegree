package com.emg.popularmovies1.models;

import com.google.gson.annotations.SerializedName;

public class Movie {

  @SerializedName("id")
  private int id;
  @SerializedName("title")
  private String title;
  @SerializedName("poster_path")
  private String imagePath;
  @SerializedName("overview")
  private String overview;
  @SerializedName("vote_average")
  private double userRating;
  @SerializedName("release_date")
  private String releaseDate;

  public Movie(int id, String title, String imagePath, String overview,
               double userRating, String releaseDate) {
    this.id = id;
    this.title = title;
    this.imagePath = imagePath;
    this.overview = overview;
    this.userRating = userRating;
    this.releaseDate = releaseDate;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getImagePath() {
    return imagePath;
  }

  public String getOverview() {
    return overview;
  }

  public double getUserRating() {
    return userRating;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public void setUserRating(double userRating) {
    this.userRating = userRating;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}