package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private Sandwich sandwich;

    public static Sandwich parseSandwichJson(String json) {
        String name;
        ArrayList<String> knownAsList = new ArrayList<>();
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> ingredientsList = new ArrayList<>();
        int i;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject mainName = jsonObject.getJSONObject("name");
            name = mainName.getString("mainName");
            JSONArray alsoKnownAs = mainName.getJSONArray("alsoKnownAs");
            for (i = 0; i < alsoKnownAs.length(); i++) {
                knownAsList.add(alsoKnownAs.getString(i));
            }
            placeOfOrigin = jsonObject.getString("placeOfOrigin");
            description = jsonObject.getString("description");
            image = jsonObject.getString("image");
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            for (i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
            System.out.println(json);
            System.out.println(name);
            System.out.println(knownAsList);
            System.out.println(placeOfOrigin);
            System.out.println(description);
            System.out.println(image);
            System.out.println(ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
