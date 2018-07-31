package com.emg.popularmovies1.utils;

import android.content.Context;
import android.util.Log;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.adapters.MovieAdapter;
import com.emg.popularmovies1.interfaces.MovieClient;
import com.emg.popularmovies1.models.Movie;
import com.emg.popularmovies1.models.Movies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Network {

  private String sortBy;
  private String apiKey;
  private int page;

  //Constructor with default value for the movie page
  public Network(String apiKey, String sortBy) {
    this(apiKey, sortBy, 1);
  }

  public Network(String apiKey, String sortBy, int page) {
    this.apiKey = apiKey;
    this.sortBy = sortBy;
    this.page = page;
  }

  public Call<Movies> moviesCall() {
    Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
    MovieClient client = retrofit.create(MovieClient.class);
    return client.movies(
        sortBy,
        apiKey,
        page
    );
  }

}
