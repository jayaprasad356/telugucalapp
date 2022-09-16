package com.vibame.telugupanchangamcalendar;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notification_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "vibamecalendar");
        Intent repiting_Intent = new Intent(context, MainActivity.class);

        repiting_Intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repiting_Intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setSmallIcon(R.drawable.arrowc)
                .setContentIntent(pendingIntent)
                .setContentTitle("ఈరోజు పంచాంగం")
                .setAutoCancel(true);

        notificationManager.notify(100, builder.build());
    }
}
