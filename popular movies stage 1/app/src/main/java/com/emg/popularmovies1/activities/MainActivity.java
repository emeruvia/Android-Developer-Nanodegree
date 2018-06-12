package com.emg.popularmovies1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.adapters.MovieAdapter;
import com.emg.popularmovies1.interfaces.Constants;
import com.emg.popularmovies1.interfaces.MovieClient;
import com.emg.popularmovies1.models.Movie;
import com.emg.popularmovies1.models.Movies;
import com.emg.popularmovies1.network.RetrofitClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.movies_rv)
  RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    Retrofit retrofit = RetrofitClient.getClient(Constants.BASE_URL);
    MovieClient client = retrofit.create(MovieClient.class);
    Call<Movies> call = client.movies(Constants.SORT_POPULAR, getResources().getString(R.string.API_KEY), 1);
    call.enqueue(new Callback<Movies>() {
      @Override
      public void onResponse(Call<Movies> call, Response<Movies> response) {
        Movies movies = response.body();
        Log.d("Page", String.valueOf(movies.getPage()));
        List<Movie> movieList = movies.getMovieList();
        for (Movie m : movieList) {
          Log.d("Movie",
              m.getTitle() + ", "
              + m.getImagePath() + "\n"
          );
        }
        MovieAdapter viewAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(viewAdapter);

      }

      @Override
      public void onFailure(Call<Movies> call, Throwable t) {
        Log.d("Status", t.toString());
      }
    });
  }

}
