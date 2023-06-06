package com.example.bookmaker;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class statusRequest extends AsyncTask<Void, Void, String> {
    String sport;
    String id;

    public interface StatusRequestCallback {
        void onStatusRequestComplete(String result);
    }
    private StatusRequestCallback callback;

    public statusRequest(String id, String sport,StatusRequestCallback callback)
    {
        this.sport=sport;
        this.id=id;
        this.callback = callback;

    }

    int daysFrom = 1;
    String dateFormat = "iso";
    static String apiKey = "133baae9a53925a3c3a415711976445b";
    static String secondApiKey = "484f5554525deda5862caf25af863b80";

    @Override
    protected String doInBackground(Void... voids) {
        String responsebody = null;
        String url = "https://api.the-odds-api.com/v4/sports/" + sport +"/scores/?daysFrom=" + daysFrom + "&apiKey="+ apiKey +"&dateFormat=" + dateFormat;
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
            Log.d("Failed to get scores: status_code ", Integer.toString(oddsResponse.code()));
            return "fail";
        } else {
            Log.d("response", responsebody);
            return responsebody;
        }
    }
    @Override
    protected void onPostExecute(String result) {
        if (!result.equals("fail")) {
            GetStatus getS = new GetStatus();
            getS.getResponse(sport,result,id);
        }else
        {
            eventlist.getStatus("pending");
        }

        if (callback != null) {
            callback.onStatusRequestComplete(result);
        }
    }
}
