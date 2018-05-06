package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .placeholder(R.drawable.placeholder)
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        TextView alsoKnownTextView = findViewById(R.id.also_known_tv);
        TextView ingredientsTextView = findViewById(R.id.ingredients_tv);
        TextView originTextView = findViewById(R.id.origin_tv);
        TextView descriptionTextView = findViewById(R.id.description_tv);
        TextView label;
        //Set the textviews with the proper text
        if (checkForNullList(sandwich.getAlsoKnownAs())) {
            alsoKnownTextView.setVisibility(View.GONE);
            label = findViewById(R.id.also_known_label);
            label.setVisibility(View.GONE);
        } else {
            alsoKnownTextView.setText(convertListToString(sandwich.getAlsoKnownAs()));
        }
        ingredientsTextView.setText(convertListToString(sandwich.getIngredients()));
        if (checkForNullString(sandwich.getPlaceOfOrigin())) {
            originTextView.setVisibility(View.GONE);
            label = findViewById(R.id.origin_label);
            label.setVisibility(View.GONE);
        } else {
            originTextView.setText(sandwich.getPlaceOfOrigin());
        }
        descriptionTextView.setText(sandwich.getDescription());
    }

    /**
     * Converts a String List to a single list, checks when a new line has to be entered
     *
     * @param list, list that has to be parsed
     * @return string with the proper data.
     */
    private String convertListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int i = list.size();
        for (String s : list) {
            sb.append(s);
            i--;
            if (i != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private boolean checkForNullList(List<String> list) {
        return list.get(0).equals("");
    }

    private boolean checkForNullString(String word) {
        return word.equals("");
    }
}
