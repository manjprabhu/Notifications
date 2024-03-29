package com.btk.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import com.btk.notifications.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat mNotificationMgrCompat;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        NotificationUtil notificationUtil = new NotificationUtil(this);
        mNotificationMgrCompat = NotificationManagerCompat.from(this);
    }

    public void createNotificationOne(View view) {
        Notification notificationCompat = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel1)
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setContentText(mBinding.idMessage.getText().toString()).build();
        mNotificationMgrCompat.notify(1, notificationCompat);
    }

    public void createNotificationTwo(View view) {

        Notification notification = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_channel2)
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setContentText(mBinding.idMessage.getText().toString()).build();
        mNotificationMgrCompat.notify(2, notification);
    }

    public void createNotificationThree(View view) {
        Notification notification = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_3)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setContentText(mBinding.idMessage.getText().toString()).build();
        mNotificationMgrCompat.notify(3, notification);
    }

    public void createNotificationwithButton(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("title", mBinding.idTitle.getText().toString());

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel1)
                .setContentText(mBinding.idMessage.getText().toString())
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .addAction(R.drawable.ic_call_black, "Accept", pendingIntent);

        Notification notification = builder.build();
        mNotificationMgrCompat.notify(1, notification);
    }

    public void createNotificationwithImage(View view) {
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.nav_header_background)).getBitmap();
        Notification notification = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentText(mBinding.idMessage.getText().toString())
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null)).build();
        mNotificationMgrCompat.notify(1, notification);
    }

    public void createNotificationwithBigtext(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentTitle(mBinding.idTitle.getText().toString())
                .setContentText(mBinding.idMessage.getText().toString())
                .setStyle(new NotificationCompat.BigTextStyle().bigText("This is expanded text notification example"));

        Notification notification = builder.build();
        mNotificationMgrCompat.notify(1, notification);
    }
}
