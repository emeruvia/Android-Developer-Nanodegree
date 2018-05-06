package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

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
            JSONObject name = jsonObject.getJSONObject("name");
            mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            for (i = 0; i < alsoKnownAs.length(); i++) {
                knownAsList.add(alsoKnownAs.getString(i));
            }
            if (knownAsList.size() == 0) {
                knownAsList.add("");
            }
            System.out.println(knownAsList);
            placeOfOrigin = jsonObject.getString("placeOfOrigin");
            description = jsonObject.getString("description");
            image = jsonObject.getString("image");
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
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
