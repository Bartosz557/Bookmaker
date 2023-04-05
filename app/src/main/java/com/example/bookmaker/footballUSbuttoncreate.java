package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.GridLayout.*;
import android.widget.LinearLayout;



public class footballUSbuttoncreate  extends AppCompatActivity {

    public void createbuttons(Context context,LinearLayout layout) {
        Button button = new Button(context);
        button.setText("Dynamically created Button");
        button.setLayoutParams(new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(button);
        GetOdds getOdds = new GetOdds("soccer_germany_bundesliga2");
        getOdds.execute();
    }
}
