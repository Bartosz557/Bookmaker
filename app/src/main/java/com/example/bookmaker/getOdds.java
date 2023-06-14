package com.example.bookmaker;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class getOdds extends AsyncTask<Void, Void, String> {

    private String sport;
    private Context context;
    private LinearLayout layout;
    private boolean lastarray;
    private static boolean emptylayout=true;
    private boolean arg;
    private View currentView;


    public getOdds(Context context, LinearLayout layout, String sport, boolean arg, boolean lastarray, View currentView)
    {
        this.sport=sport;
        this.context=context;
        this.layout=layout;
        this.arg = arg;
        this.lastarray=lastarray;
        this.currentView=currentView;
    }
    static String apiKey = "133baae9a53925a3c3a415711976445b";
    static String secondApiKey = "484f5554525deda5862caf25af863b80";
    @Override
    protected String doInBackground(Void... voids) {
        String regions ="eu";
        String markets = "h2h";
        String oddsFormat = "decimal";
        String dateFormat = "iso";
        String responsebody = null;
        String url = "https://api.the-odds-api.com/v4/sports/" + sport + "/odds?api_key=" + apiKey
                + "&regions=" + regions + "&markets=" + markets + "&oddsFormat=" + oddsFormat + "&dateFormat=" + dateFormat;
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
        //checking available requests
        String remainingRequests = oddsResponse.header("x-requests-remaining", "N/A");
        String usedRequests = oddsResponse.header("x-requests-used", "N/A");
        Log.d("requests", "reamaining requests: "+remainingRequests +"\n        used requests: "+ usedRequests);
        if(remainingRequests.equals("0")) {
            String apiHolder = apiKey;
            apiKey = secondApiKey;
            secondApiKey = apiHolder;
        }

        if (oddsResponse.code() != 200) {
            Log.d("Failed to get odds: status_code ", Integer.toString(oddsResponse.code()));
        } else {
            Log.d("response", responsebody);
            return responsebody;
        }
        return "";
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.length()>5) {
            dynamicButtonCreate sendevents = new dynamicButtonCreate(context, layout, result, arg, currentView,sport);
            sendevents.getEvents();
            emptylayout=false;
        }else
        {
            if(lastarray&&emptylayout) {
                noEventsNoti.noEvents(context, layout);
                Log.d("result", "break zdarzen");
            }
        }
        Log.d("layout", Boolean.toString(emptylayout));
    }
}
