package com.example.dangolk.notifyapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.icu.text.TimeZoneNames;
import android.os.Parcelable;
import android.security.keystore.UserNotAuthenticatedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 40111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);




    }

    public void myButtonClicked(View view){
        notification.setSmallIcon(R.drawable.linux);
        notification.setTicker("Linux is awesome!");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentText("Let's learn it properly");
        notification.setContentTitle("Learning Notify");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        nm.notify(uniqueID, notification.build());

    }
}
