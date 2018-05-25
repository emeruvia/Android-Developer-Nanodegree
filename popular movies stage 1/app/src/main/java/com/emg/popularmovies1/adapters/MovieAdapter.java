package com.emg.popularmovies1.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.emg.popularmovies1.models.Movie;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class MovieAdapter extends AbstractItem<MovieAdapter, MovieAdapter
    .ViewHolder> {

  private List<Movie> movieList;

  @NonNull
  @Override
  public ViewHolder getViewHolder(View v) {
    return null;
  }

  @Override
  public int getType() {
    return 0;
  }

  @Override
  public int getLayoutRes() {
    return 0;
  }

  protected static class ViewHolder extends FastAdapter
      .ViewHolder<MovieAdapter> {

    public ViewHolder(View view) {
      super(view);

    }

    @Override
    public void bindView(MovieAdapter item, List<Object> payloads) {

    }

    @Override
    public void unbindView(MovieAdapter item) {

    }
  }

}
