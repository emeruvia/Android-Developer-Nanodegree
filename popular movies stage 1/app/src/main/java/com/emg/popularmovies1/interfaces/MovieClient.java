package com.emg.popularmovies1.interfaces;

import com.emg.popularmovies1.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieClient {
  @GET("3/movie/{search}")
  Call<Movies> movies(@Path("search") String search, @Query("api_key") String api_key);
}
