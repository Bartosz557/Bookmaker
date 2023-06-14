package com.example.bookmaker;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
public class SendStatusNoti extends Service {
    private boolean finished=true;
    private static final String CHANNEL_ID = "MyChannelId";
    private static final int NOTIFICATION_ID = 1;
    private static final int REQUEST_CODE = 123;
    @Override
    public void onCreate() {
        super.onCreate();
        setupPeriodicTask();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Perform your desired tasks here
        checkStatus();
        checkCouponStatus();
        if(finished)
            sendNotification("Witaj, Twoj zaklad wlasnie sie zakonczyl! Klknij i sprawdz wynik");
        return START_STICKY;
    }
    static int eventId=0;
    private void checkStatus()
    {
        String sport="";
        String eventApiId="";
        String betStatus="";
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        Cursor eventsCursor = myDB.rawQuery("SELECT * FROM events", null);
        while (eventsCursor.moveToNext()) {
            int eventIdIndex = eventsCursor.getColumnIndex("event_id");
            int sportIdIndex = eventsCursor.getColumnIndex("sport");
            int eventApiIdIndex = eventsCursor.getColumnIndex("event_api_id");
            int betStatusIndex = eventsCursor.getColumnIndex("bet_status");
            if (eventIdIndex != -1)
                eventId = eventsCursor.getInt(eventIdIndex);
            if (sportIdIndex != -1)
                sport = eventsCursor.getString(sportIdIndex);
            if (eventApiIdIndex != -1)
                eventApiId = eventsCursor.getString(eventApiIdIndex);
            if (betStatusIndex != -1)
                betStatus = eventsCursor.getString(betStatusIndex);
            if(!betStatus.equals("pending"))
            {
                statusRequest getStatus = new statusRequest(eventApiId, sport, new statusRequest.StatusRequestCallback() {
                    @Override
                    public void onStatusRequestComplete(String result) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("bet_status", "new_status");
                        String tableName = "events";
                        String whereClause = "event_id = ?";
                        String[] whereArgs = { String.valueOf(eventId) };
                        myDB.update(tableName, contentValues, whereClause, whereArgs);
                    }
                });
                getStatus.execute();
            }
        }
        myDB.close();
    }
    private void checkCouponStatus()
    {
        String status="";
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        Cursor betCouponCursor = myDB.rawQuery("SELECT * FROM BetCoupons", null);
        while (betCouponCursor.moveToNext()) {
            int betIdIndex = betCouponCursor.getColumnIndex("bet_id");
            int betId = 0;
            if (betIdIndex != -1)
                betId = betCouponCursor.getInt(betIdIndex);
            String query = "SELECT * FROM events WHERE bet_id = ?";
            String selectionArg = Integer.toString(betId);
            Log.d("readCoupons: ", selectionArg);
            Cursor eventsCursor = myDB.rawQuery(query, new String[]{selectionArg});
            while (eventsCursor.moveToNext()) {

                int betStatusIndex = eventsCursor.getColumnIndex("bet_status");
                String betStatus = "";
                if (betStatusIndex != -1)
                    betStatus = eventsCursor.getString(betStatusIndex);
                if (betStatus.equals("pending")) {
                    finished = false;
                    break;
                }else
                    if(betStatus.equals("failed"))
                    {
                        status="failed";
                    }
            }
            if(finished)
            {
                ContentValues contentValues = new ContentValues();
                if(status.equals("failed"))
                    contentValues.put("coupon_status", status);
                else
                    contentValues.put("coupon_status", "succes");
                String tableName = "events";
                String whereClause = "event_id = ?";
                String[] whereArgs = { String.valueOf(eventId) };
                myDB.update(tableName, contentValues, whereClause, whereArgs);
            }
        }
    }
    private void sendNotification(String message) {
        createNotificationChannel();
        Intent intent = new Intent(this, mainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Twoj zaklad!")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "My Notification Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void setupPeriodicTask() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, SendStatusNoti.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long intervalMillis = 60 * 60 * 1000;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + intervalMillis, pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + intervalMillis, pendingIntent);
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}