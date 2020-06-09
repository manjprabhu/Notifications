package com.btk.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import com.btk.notifications.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        NotificationUtil notificationUtil = new NotificationUtil(this);
        notificationManager = NotificationManagerCompat.from(this);
    }

    public void createNotificationOne(View view) {
        Notification notificationCompat = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel1)
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setContentText(mainBinding.idMessage.getText().toString()).build();

        notificationManager.notify(1,notificationCompat);

    }

    public void createNotificationTwo(View view) {

        Notification notification = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_channel2)
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setContentText(mainBinding.idMessage.getText().toString()).build();

        notificationManager.notify(2,notification);
    }

    public void createNotificationThree(View view) {

        Notification notification = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_3)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setContentText(mainBinding.idMessage.getText().toString()).build();

        notificationManager.notify(3,notification);
    }

    public void createNotificationwithButton(View view) {
        Intent intent = new Intent(this,WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("title",mainBinding.idTitle.getText().toString());

        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel1)
                .setContentText(mainBinding.idMessage.getText().toString())
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .addAction(R.drawable.ic_call_black,"Accept",pendingIntent);

        Notification notification = builder.build();
        notificationManager.notify(1,notification);

    }

    public void createNotificationwithImage(View view) {

        Bitmap bitmap=  ((BitmapDrawable)getResources().getDrawable(R.drawable.nav_header_background)).getBitmap();
        Notification notification = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentText(mainBinding.idMessage.getText().toString())
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null)).build();

        notificationManager.notify(1,notification);
    }

    public void createNotificationwithBigtext(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,NotificationUtil.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_channel3)
                .setContentTitle(mainBinding.idTitle.getText().toString())
                .setContentText(mainBinding.idMessage.getText().toString())
                .setStyle(new NotificationCompat.BigTextStyle().bigText("This is expanded text notification example"));

        Notification notification = builder.build();
        notificationManager.notify(1,notification);
    }
}
