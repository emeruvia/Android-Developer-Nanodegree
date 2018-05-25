package com.emg.popularmovies1.models;

import android.media.Image;

public class Movie {

  private int id;
  private int voteAverage;
  private String title;
  private int popularity;
  private String poster;
  private String overview;
  private String releaseDate;

  //Default Constructor
  public Movie() {

  }

  public Movie(int id, int voteAverage, String title, int popularity,
               String poster, String overview, String releaseDate) {
    this.id = id;
    this.voteAverage = voteAverage;
    this.title = title;
    this.popularity = popularity;
    this.poster = poster;
    this.overview = overview;
    this.releaseDate = releaseDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(int voteAverage) {
    this.voteAverage = voteAverage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}
