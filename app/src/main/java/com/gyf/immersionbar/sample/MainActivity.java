package com.gyf.immersionbar.sample;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImmersionBar.with(this)
                .statusBarColor(R.color.app_top_bar)
                .statusBarDarkFont(isDayMode())
                .fitsSystemWindows(true)
                .keyboardEnable(true)
                .init();

        findViewById(R.id.switch_theme).setOnClickListener(v -> {
            MyApp app = (MyApp) getApplicationContext();
            if (app.day_night_mode == AppCompatDelegate.MODE_NIGHT_YES) {
                app.day_night_mode = AppCompatDelegate.MODE_NIGHT_NO;
            } else {
                app.day_night_mode = AppCompatDelegate.MODE_NIGHT_YES;
            }
            AppCompatDelegate.setDefaultNightMode(app.day_night_mode);
            recreate();
        });
    }

    //检查当前主题是否是白天模式
    protected boolean isDayMode() {
        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentMode == Configuration.UI_MODE_NIGHT_NO;
    }
}