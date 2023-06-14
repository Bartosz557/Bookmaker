package com.example.bookmaker;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class getStatus {

    static Map<String, String> responses = new HashMap<>();
    public void getResponse(String sport, String response,String targetid)
    {
        responses.put(sport,response);
        String json="";
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        if (responses.containsKey(sport))
            json =  responses.get(sport);
        Log.d( "getResponse: ",json);
        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            JsonElement completedElement = jsonObject.get("completed");
            String completedString = completedElement.toString();
            if(completedString.equals("false"))
            {
                eventlist.getWinner("-");
                break;
            }
            JsonObject clusterObject = element.getAsJsonObject();
            String id = clusterObject.get("id").getAsString();
            if (id.equals(targetid)) {
                String homeScore = clusterObject.get("scores").getAsJsonArray().get(0).getAsJsonObject().get("score").getAsString();
                String awayScore = clusterObject.get("scores").getAsJsonArray().get(1).getAsJsonObject().get("score").getAsString();
                String homeTeam = clusterObject.get("home_team").getAsString();
                String awayTeam = clusterObject.get("away_team").getAsString();
                Log.d( "Home Score: "  ,homeScore);
                Log.d( "Away Score: "  ,awayScore);
                if(Integer.parseInt(homeScore)>Integer.parseInt(awayScore))
                    eventlist.getWinner(homeTeam);
                else
                    eventlist.getWinner(awayTeam);
                break;
            }
        }

    }
}
