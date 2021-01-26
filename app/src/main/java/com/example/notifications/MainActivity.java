package com.example.notifications;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void createNotification(View view) {

        NotificationManager notificationManager=(NotificationManager)getSystemService(this.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Title")
                .setContentText("Message from Khan")
                .setSubText("This is a sample notification")
                .setAutoCancel(true);

        Notification notification = notificationBuilder.build();
        notificationManager.notify(4, notification);
    }

    public void anotherNotification(View view) {

        NotificationManager notificationManager=(NotificationManager)getSystemService(this.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "Another")
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Title")
                .setContentText("Message from Khan")
                .setSubText("This is a sample notification")
                .setAutoCancel(true);


        Intent intent = new Intent(this, anotherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);
        notificationBuilder.setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();
        notificationManager.notify(5, notification);
    }
}