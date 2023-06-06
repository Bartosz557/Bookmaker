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
    private View currentView;
    private int eventnumber;
    private String sport;
    public DynamicButtonCreate(Context context, LinearLayout parentlayout, String events,boolean arg, View currentView,String sport)
    {
        this.sport=sport;
        this.events=events;
        this.context=context;
        this.parentlayout=parentlayout;
        createHeader = arg;
        this.currentView=currentView;
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
    public boolean missingOdds()
    {
        try {
            jsonObjectList.get(eventnumber).getAsJsonArray("bookmakers").get(0).getAsJsonObject();
        } catch (IndexOutOfBoundsException e) {
            Log.d("error", e.toString());
            return true;
        }
        return false;
    }
    //creating all event elements on layout
    public void createbuttons() {
        //catching events does not have a single bookmaker odd provided
        if(missingOdds())
            return;
        createBetName();
        createLeftBet();
        createBackground();
    }
    public void createLeftBet() {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        parentlayout.addView(linearLayout);
        Button button = new Button(linearLayout.getContext());
        String odd = getOdd(0);
        String id = getId();
        String ht = getHN();
        String at = getAN();
        button.setText(odd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d( "onClick: ",id);
                Coupon.addEventToCoupon(id,odd,ht,at,0,sport);
                Coupon.setCouponBox(currentView);
            }
        });
        button.setWidth(305);
        button.setHeight(150);
        button.setTextSize(15);
        button.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(button);
        createDraw(linearLayout);
    }
    public void createDraw(LinearLayout linearLayout) {
        Button button = new Button(linearLayout.getContext());
        String odd = getOdd(2);
        String id = getId();
        String ht = getHN();
        String at = getAN();
        button.setText(odd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("-")) {
                    Toast.makeText(context, "Brak mozliwosci remisu", Toast.LENGTH_SHORT).show();
                }
                else {
                    Coupon.addEventToCoupon(id,odd,ht,at,1,sport);
                    Coupon.setCouponBox(currentView);
                }
            }
        });
        button.setWidth(305);
        button.setHeight(150);
        linearLayout.addView(button);
        button.setTextSize(15);
        button.setTypeface(null, Typeface.BOLD);
        createRightBet(linearLayout);
    }
    public void createRightBet(LinearLayout linearLayout) {
        Button button = new Button(linearLayout.getContext());
        String odd = getOdd(1);
        String id = getId();
        String ht = getHN();
        String at = getAN();
        button.setText(odd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                Log.d( "onClick: ",id);
                Coupon.addEventToCoupon(id,odd,ht,at,2,sport);
                Coupon.setCouponBox(currentView);            }
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
        layoutParams.setMargins(10, 30, 10, 10);
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
    public String getId()
    {
        String id =jsonObjectList.get(eventnumber).get("id").getAsString();
        return id;
    }
    public String getHN()
    {
        String hn =jsonObjectList.get(eventnumber).get("home_team").getAsString();
        return hn;
    }

    public String getAN()
    {
        String an =jsonObjectList.get(eventnumber).get("away_team").getAsString();
        return an;
    }
    public String getOdd(int i)
    {
        Log.d("event number:", Integer.toString(eventnumber));
        JsonArray bookmakers2 = jsonObjectList.get(eventnumber).getAsJsonArray("bookmakers");
        JsonObject bookmaker = bookmakers2.get(0).getAsJsonObject();
        JsonArray markets2 = bookmaker.getAsJsonArray("markets");
        JsonObject market = markets2.get(0).getAsJsonObject();
        //2nd array = draw array
        if(i==2) {
            //if the bet doesnt allow draw
            if (!market.toString().contains("Draw")) {
                //getting draw value if first bookmaker doesnt give it;
                JsonObject drawValue = getDraw();
                if(drawValue.size()>1)
                    market=drawValue;
                else
                    return "-";
            }
        }
        JsonArray outcomes = market.getAsJsonArray("outcomes");
        JsonObject outcome = outcomes.get(i).getAsJsonObject();
        return (outcome.get("price").getAsString());
    }
    //getting draw odd
    public JsonObject getDraw() {
        JsonArray bookmakers2 = jsonObjectList.get(eventnumber).getAsJsonArray("bookmakers");
        for(int i=0;i<bookmakers2.size();i++){
            JsonObject bookmaker = bookmakers2.get(i).getAsJsonObject();
            JsonArray markets2 = bookmaker.getAsJsonArray("markets");
            JsonObject market = markets2.get(0).getAsJsonObject();
            if (!market.toString().contains("Draw")) {
                continue;
            }
            else
                return market;
        }
        JsonObject empty = new JsonObject();
        return empty;
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
        if(parentlayout.getChildCount()==0)
            layoutParams.setMargins(10, 10, 10, 30);
        else
            layoutParams.setMargins(10, 50, 10, 30);


        textView.setHeight(150);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(0xFFD7D7D6);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        parentlayout.addView(textView);
    }
}
