package com.samsung.mno.t_mobile.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.samsung.mno.t_mobile.datacollection.framework.DataCollectionInitializer;
import com.samsung.mno.t_mobile.issueassist.base.service.IssueAssistService;
import com.samsung.mno.t_mobile.service.AlertService;

public class BootListener extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "boot completed", Toast.LENGTH_SHORT).show();
        Log.e("BootReceiver","boot completed intent received");

        Intent i = new Intent(context, IssueAssistService.class);
        context.startService(i);
        Intent i2 = new Intent(context, DataCollectionInitializer.class);
        context.startService(i2);
        Intent i3 = new Intent(context, AlertService.class);
        context.startService(i3);
    }
}
