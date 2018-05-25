package com.emg.popularmovies1.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.emg.popularmovies1.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String url = "http://api.themoviedb" +
        ".org/3/movie/popular?api_key=" + getResources().getString(R.string
        .API_KEY);
    System.out.println(url);
    new FetchData().execute(url);

  }

  public class FetchData extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
      StringBuilder result = new StringBuilder();
      URL url;
      HttpURLConnection urlConnection;
      try {
        url = new URL(strings[0]);
        urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        int data = reader.read();
        while (data != -1) {
          char current = (char) data;
          result.append(current);
          data = reader.read();
        }
        return result.toString();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      try {
        JSONObject jsonObject = new JSONObject(s);
        JSONArray results = jsonObject.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
          System.out.println(results.get(i));
        }
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
  }
}
