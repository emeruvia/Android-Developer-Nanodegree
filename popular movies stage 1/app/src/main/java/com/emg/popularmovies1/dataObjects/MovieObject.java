package com.emg.popularmovies1.dataObjects;

import android.media.Image;

public class MovieObject {

  private String title;
  private String releaseDate;
  private Image poster;
  private String voteAverage;
  private String plotSynopsis;

  //Default Constructor
  public MovieObject() {

  }

  public MovieObject(String title, String releaseDate, Image poster,
                     String voteAverage, String plotSynopsis) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.poster = poster;
    this.voteAverage = voteAverage;
    this.plotSynopsis = plotSynopsis;
  }

  public String getTitle() {z
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Image getPoster() {
    return poster;
  }

  public void setPoster(Image poster) {
    this.poster = poster;
  }

  public String getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(String voteAverage) {
    this.voteAverage = voteAverage;
  }

  public String getPlotSynopsis() {
    return plotSynopsis;
  }

  public void setPlotSynopsis(String plotSynopsis) {
    this.plotSynopsis = plotSynopsis;
  }
}
