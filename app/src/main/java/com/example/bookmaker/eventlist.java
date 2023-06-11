package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.CountDownLatch;

import javax.security.auth.callback.Callback;

public class eventlist extends AppCompatActivity {

    static String score="";

    static String currentstatus="pending";
    String sport="",teams="";
    static String eventId="";
    String eventApiId="";
    String eventOdds="";
    static String betWinner="";
    static String betStatus="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        readCoupons();
    }

    public int getBetId()
    {
        return couponslist.currentBetId;
    }

    private void readCoupons()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        String query = "SELECT * FROM events WHERE bet_id = ?";
        String selectionArg = Integer.toString(getBetId());
        Log.d("readCoupons: ",selectionArg);
        Cursor eventsCursor = myDB.rawQuery(query, new String[]{selectionArg});
        while (eventsCursor.moveToNext()) {
            int eventIdIndex = eventsCursor.getColumnIndex("event_id");
            int sportIdIndex = eventsCursor.getColumnIndex("sport");
            int teamsIdIndex = eventsCursor.getColumnIndex("teams");
            int eventApiIdIndex = eventsCursor.getColumnIndex("event_api_id");
            int eventOddsIndex = eventsCursor.getColumnIndex("event_odds");
            int betWinnerIndex = eventsCursor.getColumnIndex("bet_winner");
            int betStatusIndex = eventsCursor.getColumnIndex("bet_status");

//            int eventId=0;
//            int betId=0;
//            String eventApiId="";
//            float eventOdds=0;
//            String betWinner="";
//            String betStatus="";

            if (eventIdIndex != -1)
                eventId = eventsCursor.getString(eventIdIndex);
            if (sportIdIndex != -1)
                sport = eventsCursor.getString(sportIdIndex);
            if (teamsIdIndex != -1)
                teams = eventsCursor.getString(teamsIdIndex);
            if (eventApiIdIndex != -1)
                eventApiId = eventsCursor.getString(eventApiIdIndex);
            if (eventOddsIndex != -1)
                eventOdds = eventsCursor.getString(eventOddsIndex);
            if (betWinnerIndex != -1)
                betWinner = eventsCursor.getString(betWinnerIndex);
            if (betStatusIndex != -1)
                betStatus = eventsCursor.getString(betStatusIndex);
            // Print the values
            Log.d("Events", "Event ID: " + eventId);
            Log.d("Events", "Event API ID: " + eventApiId);
            Log.d("Events", "Event Odds: " + eventOdds);
            Log.d("Events", "Bet Winner: " + betWinner);
            Log.d("Events", "Bet Status: " + betStatus);
            printCoupons();

        }
        eventsCursor.close();
    }


    private void printCoupons()
    {
        Log.d( "getStatus: ",currentstatus);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.eventboxtemplate, null);
        LinearLayout layout = findViewById(R.id.eventlayout);
        TextView betname = view.findViewById(R.id.betname);
        TextView bettype = view.findViewById(R.id.bettype);
        TextView betscore = view.findViewById(R.id.betscore);
        TextView betodd = view.findViewById(R.id.betodd);
        ImageView betstatus = view.findViewById(R.id.betstatus);
        ImageButton searchbutton = view.findViewById(R.id.searchbutton);
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/search?q=" + teams + "score");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
//            int eventId=0;
//            int betId=0;
//            String eventApiId="";
//            float eventOdds=0;
//            String betWinner="";
//            String betStatus="";
        if(!score.equals(betWinner)&&!currentstatus.equals("pending"))
            currentstatus="failed";
        else
            currentstatus="succes";
        Log.d("printCoupons: ",teams);
        betname.setText(teams);
        bettype.setText(betWinner);
        betodd.setText(eventOdds);
        statusRequest getStatus = new statusRequest(eventApiId, sport, new statusRequest.StatusRequestCallback() {
            @Override
            public void onStatusRequestComplete(String result) {
                betscore.setText(score);
                //betstatus.setImageIcon(); currentstatus
                layout.addView(view);
                Log.d( "onStatusRequestComplete: ",currentstatus);
                Log.d( "onStatusRequestComplete: ",betStatus);
                if(!currentstatus.equals(betStatus))
                    updateStatus(currentstatus,eventId);
            }
        });
        getStatus.execute();

    }

    public void updateStatus(String status,String id) {
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
            ContentValues contentValues = new ContentValues();
            contentValues.put("bet_status", status);
            String tableName = "events";
            String whereClause = "event_id = ?";
            String[] whereArgs = {id};
            myDB.update(tableName, contentValues, whereClause, whereArgs);
            myDB.close();
    }

    public static void getStatus(String stat)
    {
        if(stat.equals(betWinner))
            currentstatus="succes";
        else
            currentstatus="failed";

    }
    public static void getWinner(String stat)
    {
        score=stat;
    }


}