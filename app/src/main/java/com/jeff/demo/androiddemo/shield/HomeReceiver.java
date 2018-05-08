package com.jeff.demo.androiddemo.shield;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.jeff.demo.androiddemo.MainActivity;
import com.jeff.demo.androiddemo.utils.LogUtils;

/**
 * Created by ttxs on 2018/4/16.
 */

public class HomeReceiver extends BroadcastReceiver
{
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_RECENT_KEY = "recentapps";
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if (TextUtils.equals(action, Intent.ACTION_CLOSE_SYSTEM_DIALOGS))
        {
            String reason = intent.getStringExtra
                    (SYSTEM_DIALOG_REASON_KEY);
            if (reason != null)
            {
                if (TextUtils.equals(reason, SYSTEM_DIALOG_REASON_HOME_KEY))
                {
                    LogUtils.e("Home被按了");
                    for (int i = 0; i < 10; i++)
                    {
                        Intent intent1 = new Intent(context, MainActivity
                                .class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity
                                (context, 0, intent1, 0);
                        try
                        {
                            pendingIntent.send();
                        } catch (PendingIntent.CanceledException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }else if (TextUtils.equals(reason,
                        SYSTEM_DIALOG_REASON_RECENT_KEY)){
                    LogUtils.e("recent被按了····");
                    for (int i = 0; i < 10; i++)
                    {
                        Intent intent1 = new Intent(context, MainActivity
                                .class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity
                                (context, 0, intent1, 0);
                        try
                        {
                            pendingIntent.send();
                        } catch (PendingIntent.CanceledException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
