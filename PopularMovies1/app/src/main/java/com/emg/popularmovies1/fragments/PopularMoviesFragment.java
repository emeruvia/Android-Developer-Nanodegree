package com.emg.popularmovies1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class PopularMoviesFragment extends Fragment implements ClickListener {

  private List<Movie> movieList;
  @BindView(R.id.popular_movies_rv)
  RecyclerView mRecyclerView;

  public PopularMoviesFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_popular_movies, container, false);
    ButterKnife.bind(view);
//    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
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
        Movies movies = response.body();
        Log.d("Page", String.valueOf(movies.getPage()));
        movieList = movies.getMovieList();
        for (Movie m : movieList) {
          Log.d("Movie",
              m.getTitle() + ", " + m.getImagePath() + "\n");
        }
//        MovieAdapter viewAdapter = new MovieAdapter(movieList);
//        mRecyclerView.setAdapter(viewAdapter);
      }

      @Override
      public void onFailure(Call<Movies> call, Throwable t) {
        Log.d("Status", t.toString());
      }
    });
  }

  @Override
  public void itemClicked(View view, int position) {
    Log.d("Movie Clicked", movieList.get(position).getTitle());
  }
}