package com.emg.popularmovies1;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.emg.popularmovies1.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends AppCompatActivity {

  @BindView(R.id.details_poster_iv)
  ImageView poster;
  @BindView(R.id.details_description)
  TextView description;
  @BindView(R.id.details_rating)
  TextView rating;
  @BindView(R.id.details_release_date)
  TextView releaseDate;
  @BindView(R.id.details_title)
  TextView title;
  private Movie movie;
  private final String IMAGE_URL = "http://image.tmdb.org/t/p/w342/";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_details);
    ButterKnife.bind(this);


    Intent intent = getIntent();
    movie = (Movie) intent.getSerializableExtra("movie_info");
    setTitle(movie.getTitle());
    title.setText(String.format("Title:\n%s", movie.getTitle()));
    rating.setText(String.format("Rating:\n%s", String.valueOf(movie.getUserRating())));
    releaseDate.setText(String.format("Release Date:\n%s", movie.getReleaseDate()));
    description.setText(movie.getOverview());
    Picasso.get()
        .load(IMAGE_URL + movie.getImagePath())
        .into(poster);
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
