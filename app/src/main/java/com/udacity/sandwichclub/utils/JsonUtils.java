package com.udacity.sandwichclub.utils;

import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Log.d("Output: ", "JSON" + json);
        Sandwich sandwich=null;

        try{
            JSONObject jsonObj = new JSONObject(json);

            JSONObject nameObj = jsonObj.getJSONObject("name");
            String mainName=nameObj.getString("mainName");

            JSONArray akaArray = nameObj.getJSONArray("alsoKnownAs");

            List<String> alsoKnownAs=new ArrayList<>();
            for(int i=0;i<akaArray.length();i++)
                alsoKnownAs.add(akaArray.getString(i));

            String placeOfOrigin = jsonObj.getString("placeOfOrigin");
            String description = jsonObj.getString("description");
            String image = jsonObj.getString("image");

            JSONArray ingredientsArray = jsonObj.getJSONArray("ingredients");

            List<String> ingredients=new ArrayList<>();
            for(int i=0;i<ingredientsArray.length();i++)
                ingredients.add(ingredientsArray.getString(i));

            //Log.d("origin: ", id);

            sandwich=new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        }
        catch (final JSONException e) {
            Log.e("Error: ", "Json parsing error: " + e.getMessage());
        }

        return sandwich;
    }
}
