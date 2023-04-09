package com.example.bookmaker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.*;
import android.content.Context;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class DynamicButtonCreate  extends AppCompatActivity {

    private JsonArray jsonArray;
    private List<JsonObject> jsonObjectList;
    private String events;
    private Context context;
    private boolean createHeader;
    private LinearLayout parentlayout;
    private int eventnumber;
    public DynamicButtonCreate(Context context, LinearLayout parentlayout, String events,boolean arg)
    {
        this.events=events;
        this.context=context;
        this.parentlayout=parentlayout;
        createHeader = arg;
    }
    //getting events from json
    public void getEvents()
    {
        jsonArray = JsonParser.parseString(events).getAsJsonArray();
        Log.d("events", events);
        int eventsAmmount = events.split("\"id\"").length-1;
        Log.d("events ammount", Integer.toString(eventsAmmount));
        jsonObjectList = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            jsonObjectList.add(jsonObject);
        }
        if(createHeader)
            createCategoryHeader();
        for(int i=0;i<eventsAmmount;i++) {
            eventnumber=i;
            createbuttons();
        }
    }


    //creating all event elements on layout
    public void createbuttons() {
        createBetName();
        createLeftBet();
        createBackground();
    }
    public void createLeftBet() {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        parentlayout.addView(linearLayout);
        Button button = new Button(linearLayout.getContext());
        button.setText(getOdd(0));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
            }
        });
        button.setWidth(305);
        button.setHeight(150);
        button.setTextSize(15);
        button.setTypeface(null, Typeface.BOLD);

        linearLayout.addView(button);
        createDraw(button.getId(),linearLayout);
    }
    public void createDraw(int leftId,LinearLayout linearLayout) {
        Button button = new Button(linearLayout.getContext());
        button.setText(getOdd(2));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("-"))
                    Toast.makeText(context, "Brak mozliwosci remisu", Toast.LENGTH_SHORT).show();
                else{
                    //zzzz
                }
            }
        });
        button.setWidth(305);
        button.setHeight(150);
        linearLayout.addView(button);
        button.setTextSize(15);
        button.setTypeface(null, Typeface.BOLD);
        createRightBet(button.getId(),linearLayout);
    }
    public void createRightBet(int leftId,LinearLayout linearLayout) {
        Button button = new Button(linearLayout.getContext());
        button.setText(getOdd(1));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
            }
        });
        button.setWidth(305);
        button.setHeight(150);
        button.setTypeface(null, Typeface.BOLD);

        button.setTextSize(15);
        linearLayout.addView(button);
    }
    public void createBetName()
    {
        LinearLayout betnamelayout = new LinearLayout(context);
        betnamelayout.setOrientation(LinearLayout.HORIZONTAL);
        betnamelayout.setBackgroundColor(0xFFD7D7D6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(10, 40, 10, 10);
        betnamelayout.setLayoutParams(layoutParams);
        parentlayout.addView(betnamelayout);
        for(int i=0;i<3;i++)
        {
            TextView textView = new TextView(betnamelayout.getContext());
            textView.setGravity(Gravity.CENTER);
            if(i==0) {
                String buttontext = jsonObjectList.get(eventnumber).get("home_team").getAsString();
                textView.setWidth(425);
                ContextCompat.getColor(context, R.color.black);
                textView.setTextSize(15);
                if(buttontext.length()>17) {
                    textView.setTextSize(14);
                    int lastSpaceIndex = buttontext.lastIndexOf(" ");
                    String newtext = buttontext.substring(0, lastSpaceIndex) + "\n" + buttontext.substring(lastSpaceIndex + 1);
                    textView.setText(newtext);
                    float y = textView.getY() - 20;
                    textView.setY(y);
                }else
                    textView.setText(buttontext);

            }
            else if(i==1) {
                textView.setText("vs");
                textView.setWidth(47);
                textView.setTextSize(12);

            }
            else {
                String buttontext = jsonObjectList.get(eventnumber).get("away_team").getAsString();
                textView.setWidth(425);
                ContextCompat.getColor(context, R.color.black);
                textView.setTextSize(15);
                if(buttontext.length()>17) {
                    textView.setTextSize(14);
                    int lastSpaceIndex = buttontext.lastIndexOf(" ");
                    String newtext = buttontext.substring(0, lastSpaceIndex) + "\n" + buttontext.substring(lastSpaceIndex + 1);
                    textView.setText(newtext);
                    float y = textView.getY() - 20;
                    textView.setY(y);
                }else
                    textView.setText(buttontext);

            }
            textView.setHeight(150);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setBackgroundColor(0xFFD7D7D6);
            betnamelayout.addView(textView);
        }
    }
    public String getOdd(int i)
    {
        JsonArray bookmakers2 = jsonObjectList.get(0).getAsJsonArray("bookmakers");
        JsonObject bookmaker = bookmakers2.get(0).getAsJsonObject();
        JsonArray markets2 = bookmaker.getAsJsonArray("markets");
        JsonObject market = markets2.get(0).getAsJsonObject();
        //2nd array = draw array
        if(i==2) {
            //if the bet doesnt allow draw
            if (!market.toString().contains("Draw")) {
                return "-";
            }
        }
        JsonArray outcomes = market.getAsJsonArray("outcomes");
        JsonObject outcome = outcomes.get(i).getAsJsonObject();
        return (outcome.get("price").getAsString());
    }

    public void createBackground()
    {

    }
    //setting category element on start of all events in layout
    public void createCategoryHeader()
    {
        TextView textView = new TextView(context);
        textView.setText(jsonObjectList.get(eventnumber).get("sport_title").getAsString());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(10, 10, 10, 30);
        textView.setHeight(150);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(0xFFD7D7D6);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        parentlayout.addView(textView);
    }
}
