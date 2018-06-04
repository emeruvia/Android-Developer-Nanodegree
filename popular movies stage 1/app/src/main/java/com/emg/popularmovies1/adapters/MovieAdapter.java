package com.emg.popularmovies1.adapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.models.Movie;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    return R.layout.activity_main_moviecardview;
  }

  protected static class ViewHolder extends FastAdapter
      .ViewHolder<MovieAdapter> {

    @BindView(R.id.posterImageView)
    ImageView poster;
    @BindView(R.id.titleTextView)
    TextView movieTitle;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }

    @Override
    public void bindView(MovieAdapter item, List<Object> payloads) {

    }

    @Override
    public void unbindView(MovieAdapter item) {

    }
  }

}
