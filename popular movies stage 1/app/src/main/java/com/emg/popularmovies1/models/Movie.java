package com.emg.popularmovies1.models;

import android.media.Image;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.emg.popularmovies1.R;
import com.google.gson.annotations.SerializedName;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Movie extends AbstractItem<Movie, Movie.ViewHolder> {

  @SerializedName("id")
  private int id;
  @SerializedName("title")
  private String title;
  @SerializedName("poster_path")
  private String imagePath;
  @SerializedName("overview")
  private String overview;
  @SerializedName("vote_average")
  private double userRating;
  @SerializedName("release_date")
  private String releaseDate;

  public Movie(int id, String title, String imagePath, String overview,
               double userRating, String releaseDate) {
    this.id = id;
    this.title = title;
    this.imagePath = imagePath;
    this.overview = overview;
    this.userRating = userRating;
    this.releaseDate = releaseDate;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getImagePath() {
    return imagePath;
  }

  public String getOverview() {
    return overview;
  }

  public double getUserRating() {
    return userRating;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  @NonNull
  @Override
  public ViewHolder getViewHolder(View v) {
    return null;
  }

  @Override
  public int getType() {
    return R.id.movies_rv;
  }

  @Override
  public int getLayoutRes() {
    return R.layout.activity_main_moviecardview;
  }

  protected static class ViewHolder extends FastAdapter.ViewHolder<Movie> {

    @BindView(R.id.posterImageView)
    ImageView poster;
    @BindView(R.id.titleTextView)
    TextView movieTitle;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }

    @Override
    public void bindView(Movie item, List<Object> payloads) {

    }

    @Override
    public void unbindView(Movie item) {

    }
  }
}
