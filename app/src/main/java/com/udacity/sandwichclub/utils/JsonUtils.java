package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject names = sandwichJson.getJSONObject("name");

            String mainName = names.getString("mainName");
            List<String> alsoKnownAs = jsonArrayToListOfString(names.getJSONArray("alsoKnownAs"));
            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String image = sandwichJson.getString("image");
            List<String> ingredients = jsonArrayToListOfString(sandwichJson.getJSONArray("ingredients"));

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        return null;
    }

    private static List<String> jsonArrayToListOfString(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add(jsonArray.getString(i));
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
        }
        return list;
    }
}
