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

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.image_iv)
    ImageView ingredientsImageView;
    @BindView(R.id.also_known_tv)
    TextView alsoKnownTextView;
    @BindView(R.id.ingredients_tv)
    TextView ingredientsTextView;
    @BindView(R.id.origin_label)
    TextView originLabel;
    @BindView(R.id.origin_tv)
    TextView originTextView;
    @BindView(R.id.description_tv)
    TextView descriptionTextView;
    @BindView(R.id.also_known_label)
    TextView alsoKnownLabel;

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //bind the view using butterknife
        ButterKnife.bind(this);

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
                .into(ingredientsImageView);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    /**
     * sets the values in the UI with the sandwich that has been clicked on
     *
     * @param sandwich
     */
    private void populateUI(Sandwich sandwich) {
        TextView label;
        //Set the textviews with the proper text
        if (checkForNullList(sandwich.getAlsoKnownAs())) {
            alsoKnownTextView.setVisibility(View.GONE);
            alsoKnownLabel.setVisibility(View.GONE);
        } else {
            alsoKnownTextView.setText(convertListToString(sandwich.getAlsoKnownAs()));
        }
        ingredientsTextView.setText(convertListToString(sandwich.getIngredients()));
        if (checkForNullString(sandwich.getPlaceOfOrigin())) {
            originTextView.setVisibility(View.GONE);
            originLabel.setVisibility(View.GONE);
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

    /**
     * Checks if the list has null values
     *
     * @param list
     * @return true if the list is empty, false if there are valid values in the list
     */
    private boolean checkForNullList(List<String> list) {
        return list.get(0).equals("");
    }

    /**
     * Checks if the string is empty or not
     *
     * @param word
     * @return true if string is empty, false if string is valid
     */
    private boolean checkForNullString(String word) {
        return word.equals("");
    }
}
