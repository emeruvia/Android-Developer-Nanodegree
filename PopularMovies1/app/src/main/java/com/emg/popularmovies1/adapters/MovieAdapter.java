package com.emg.popularmovies1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.emg.popularmovies1.R;
import com.emg.popularmovies1.interfaces.ClickListener;
import com.emg.popularmovies1.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

  private List<Movie> movieList;
  private ClickListener clickListener;
  private final String IMAGE_URL = "http://image.tmdb.org/t/p/w342/";

  //Default constructor
  public MovieAdapter(List<Movie> movieList) {
    this.movieList = movieList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.movie_list_cardview, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Picasso.get()
        .load(IMAGE_URL + movieList.get(position).getImagePath())
        .into(holder.poster);
  }

  @Override
  public int getItemCount() {
    return movieList.size();
  }

  public void setClickListener(ClickListener clickListener) {
    this.clickListener = clickListener;
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.poster_image_view)
    ImageView poster;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if (clickListener != null) {
        clickListener.itemClicked(v, getLayoutPosition());
      }
    }
  }
}
