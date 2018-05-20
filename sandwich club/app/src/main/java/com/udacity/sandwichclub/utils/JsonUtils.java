package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private static final String KEY_NAME = "name";
    private static final String KEY_MAIN_NAME = "mainName";
    private static final String KEY_ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        String mainName;
        ArrayList<String> knownAsList = new ArrayList<>();
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> ingredientsList = new ArrayList<>();
        int i;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject(KEY_NAME);
            mainName = name.getString(KEY_MAIN_NAME);
            JSONArray alsoKnownAs = name.getJSONArray(KEY_ALSO_KNOWN_AS);
            for (i = 0; i < alsoKnownAs.length(); i++) {
                knownAsList.add(alsoKnownAs.getString(i));
            }
            if (knownAsList.size() == 0) {
                knownAsList.add("");
            }
            System.out.println(knownAsList);
            placeOfOrigin = jsonObject.getString(KEY_PLACE_OF_ORIGIN);
            description = jsonObject.getString(KEY_DESCRIPTION);
            image = jsonObject.optString(KEY_IMAGE);
            JSONArray ingredients = jsonObject.getJSONArray(KEY_INGREDIENTS);
            for (i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
            return new Sandwich(mainName, knownAsList, placeOfOrigin, description,
                    image, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
