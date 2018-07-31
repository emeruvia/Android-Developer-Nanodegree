package com.emg.popularmovies1.utils;

import android.content.Context;
import android.util.Log;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.interfaces.MovieClient;
import com.emg.popularmovies1.models.Movie;
import com.emg.popularmovies1.models.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Network {

  private List<Movie> movieList;

  //Constructor with default value for the movie page
  public Network(Context context, String sortBy) {
    new Network(context, sortBy, 1);
  }

  public Network(Context context, String sortBy, int page) {
    Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
    MovieClient client = retrofit.create(MovieClient.class);
    Call<Movies> call = client.movies(
        sortBy,
        context.getResources().getString(R.string.API_KEY),
        page
    );
    call.enqueue(new Callback<Movies>() {
      @Override
      public void onResponse(Call<Movies> call, Response<Movies> response) {
        Movies movies = response.body();
        Log.d("Page", String.valueOf(movies.getPage()));
        movieList = movies.getMovieList();
        for (Movie m : movieList) {
          Log.d("Movie", m.getTitle() + ", " + m.getImagePath() + "\n");
        }
      }

      @Override
      public void onFailure(Call<Movies> call, Throwable t) {
        Log.d("Status", t.toString());
      }
    });
  }
}
