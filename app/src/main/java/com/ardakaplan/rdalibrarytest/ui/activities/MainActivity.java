package com.ardakaplan.rdalibrarytest.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.ardakaplan.rdalibrary.ui.dialogs.RDAProgressDialog;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.services.BackgroundService;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        testBackgroundService();

    }

    private void testBackgroundService() {

        startService(new Intent(this, BackgroundService.class));
    }

    @OnClick(R.id.main_button_recyclerview)
    void openRecyclerView() {

        startActivity(new Intent(this, RecyclerActivity.class));

    }

    @OnClick(R.id.main_button_notification)
    void notification() {

        startActivity(new Intent(this, NotificationActivity.class));
    }
}