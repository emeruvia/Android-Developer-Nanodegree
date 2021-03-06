package com.emg.popularmovies1.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

  @SerializedName("page")
  private int page;
  @SerializedName("total_results")
  private int totalResults;
  @SerializedName("total_pages")
  private int totalPages;
  @SerializedName("results")
  List<Movie> movieList;

  public int getPage() {
    return page;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public List<Movie> getMovieList() {
    return movieList;
  }
}
