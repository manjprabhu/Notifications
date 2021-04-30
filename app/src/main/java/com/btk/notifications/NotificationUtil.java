package com.btk.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class NotificationUtil {

    public static final String CHANNEL_ID_1 = "channel1";
    public static final String CHANNEL_ID_2 = "channel2";
    public static final String CHANNEL_ID_3 = "channel3";
    public NotificationChannel channel1, channel2, channel3;
    private NotificationManager notificationManager;

    public NotificationUtil(Context context) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        CreateNotificationChannel();
    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            channel1 = new NotificationChannel(CHANNEL_ID_1,
                    "Channel1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setShowBadge(true);

            channel2 = new NotificationChannel(CHANNEL_ID_2,
                    "Channel2", NotificationManager.IMPORTANCE_LOW);

            channel3 = new NotificationChannel(CHANNEL_ID_3,
                    "Channel3", NotificationManager.IMPORTANCE_MIN);

            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);
            notificationManager.createNotificationChannel(channel3);
        }
    }
}
