package com.emg.popularmovies1;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.emg.popularmovies1.fragments.PopularMoviesFragment;
import com.emg.popularmovies1.fragments.TopRatedFragment;
import com.emg.popularmovies1.utils.Constants;
import com.emg.popularmovies1.utils.Network;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener{

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
  @BindView(R.id.nav_view) NavigationView mNavigationView;
  private FragmentManager fragmentManager;
  private Fragment fragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    fragmentManager = getSupportFragmentManager();
    fragment = new PopularMoviesFragment();
    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//    new Network(this, Constants.SORT_POPULAR);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    mNavigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        mDrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    item.setChecked(true);
    mDrawerLayout.closeDrawers();
    Log.d("MenuItem", item.getTitle() + " clicked");
    switch(item.getItemId()) {
      case R.id.sort_by_popular:
        fragment = new PopularMoviesFragment();
//        new Network(this, Constants.SORT_POPULAR);
        break;
      case R.id.sort_by_top_rated:
        fragment = new TopRatedFragment();
//        new Network(this, Constants.SORT_TOP_RATED);
        break;
      default:
        fragment = new PopularMoviesFragment();
//        new Network(this, Constants.SORT_POPULAR);
        break;
    }
    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    setTitle(item.getTitle());
    return true;
  }
}
