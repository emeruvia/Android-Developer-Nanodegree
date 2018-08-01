package com.emg.popularmovies1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.adapters.MovieAdapter;
import com.emg.popularmovies1.interfaces.ClickListener;
import com.emg.popularmovies1.models.Movie;
import com.emg.popularmovies1.models.Movies;
import com.emg.popularmovies1.utils.Constants;
import com.emg.popularmovies1.utils.Network;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularMoviesFragment extends Fragment {

  private List<Movie> movieList;
  @BindView(R.id.movie_list_rv)
  RecyclerView mRecyclerView;
  @BindView(R.id.movie_list_progress_bar)
  ProgressBar mProgressBar;

  public PopularMoviesFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
    ButterKnife.bind(this, view);
    mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    fetchData(new Network(
        getResources().getString(R.string.API_KEY),
        Constants.SORT_POPULAR
    ));
    return view;
  }

  private void fetchData(Network network) {
    network.moviesCall().enqueue(new Callback<Movies>() {
      @Override
      public void onResponse(Call<Movies> call, Response<Movies> response) {
        mProgressBar.setVisibility(View.GONE);
        Movies movies = response.body();
        Log.d("Page", String.valueOf(movies.getPage()));
        movieList = movies.getMovieList();
        for (Movie m : movieList) {
          Log.d("Popular Movies",
              m.getTitle() + ", " + m.getImagePath() + "\n");
        }
        MovieAdapter viewAdapter = new MovieAdapter(movieList);
        viewAdapter.setClickListener(new ClickListener() {
          @Override
          public void itemClicked(View view, int position) {
            Log.d("Movie Clicked", movieList.get(position).getTitle());
          }
        });
        mRecyclerView.setAdapter(viewAdapter);
      }

      @Override
      public void onFailure(Call<Movies> call, Throwable t) {
        Log.d("Status", t.toString());
      }
    });
  }
}
