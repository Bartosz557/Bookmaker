package com.example.bookmaker;
import android.os.AsyncTask;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class GetOdds extends AsyncTask<Void, Void, String> {

    private String sport;
    public GetOdds(String sport)
    {
        this.sport=sport;
    }
    @Override
    protected String doInBackground(Void... voids) {
        String apiKey = "484f5554525deda5862caf25af863b80";
        String bookmakers = "betclic";
        String markets = "h2h";
        String oddsFormat = "decimal";
        String dateFormat = "iso";
        String responsebody=null;
        String url = "https://api.the-odds-api.com/v4/sports/" + sport + "/odds?api_key=" + apiKey
                + "&bookmakers=" + bookmakers + "&markets=" + markets + "&oddsFormat=" + oddsFormat + "&dateFormat=" + dateFormat;
        Request oddsRequest = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Response oddsResponse = null;
        try {
            oddsResponse = okHttpClient.newCall(oddsRequest).execute();
            responsebody = oddsResponse.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (oddsResponse.code() != 200) {
            System.out.println("Failed to get odds: status_code " + oddsResponse.code() + ", response body " + oddsResponse.body());
        } else {
            JsonArray jsonArray = JsonParser.parseString(responsebody).getAsJsonArray();

            List<JsonObject> jsonObjectList = new ArrayList<>();
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                jsonObjectList.add(jsonObject);
            }
            Log.d("API Response Body", responsebody);
            String x = jsonObjectList.get(0).get("id").getAsString();
            Log.d("ID", x);
            String y = jsonObjectList.get(0).get("home_team").getAsString();
            Log.d("Home Team", y);


            //    arguments = {"id:", "sport_key:", "sport_title:", "commence_time:", "home_team:", "away_team:", "bookmakers:", "last_update:", "markets:", "outcomes:"};
            // usage status
        }
        return null;
    }

}
