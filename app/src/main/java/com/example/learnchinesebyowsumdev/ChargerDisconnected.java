package com.example.learnchinesebyowsumdev;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ChargerDisconnected extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Charger disconnected!", Toast.LENGTH_SHORT).show();
    }
}