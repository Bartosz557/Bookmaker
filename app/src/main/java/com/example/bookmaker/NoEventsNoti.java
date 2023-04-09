package com.example.bookmaker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoEventsNoti {
    public static void noEvents(Context context, LinearLayout parentlayout)
    {
        TextView textView = new TextView(context);
        textView.setText("Brak aktualnych wydarzen z tej kategorii.");
        textView.setTextSize(14);
        textView.setHeight(150);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(dpToPx(16), dpToPx(16), dpToPx(16), dpToPx(16));
        textView.setBackground(getRoundedBackground());
        textView.setTypeface(null, Typeface.BOLD);
        parentlayout.addView(textView);
        parentlayout.setBackgroundColor(Color.TRANSPARENT);
    }
    private static Drawable getRoundedBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(0xFFD7D7D6);
        gradientDrawable.setCornerRadius(dpToPx(20));
        return gradientDrawable;
    }
    private static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
