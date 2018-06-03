package com.emg.popularmovies1.models;

import android.media.Image;

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
}
