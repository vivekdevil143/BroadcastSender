package com.rai.vivek.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.rai.vivek.EXAMPLE_ACTION");

        //intent.setClass(this, ExampleBroadcastReceiver2.class);
       /* ComponentName cn=new ComponentName("com.rai.vivek.broadcastreceiver",
                "com.rai.vivek.broadcastreceiver.ExampleBroadcastReceiver");
        intent.setComponent(cn);*/
      /* intent.setClassName("com.rai.vivek.broadcastreceiver",
               "com.rai.vivek.broadcastreceiver.ExampleBroadcastReceiver");*/

        //intent.setPackage("com.rai.vivek.broadcastreceiver");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> infoList = packageManager.queryBroadcastReceivers(intent, 0);
        for (ResolveInfo info : infoList) {
            ComponentName cn = new ComponentName(info.activityInfo.packageName,
                    info.activityInfo.name);
            intent.setComponent(cn);
            sendBroadcast(intent);

        }

        //sendBroadcast(intent);
    }


}
