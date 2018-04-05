package com.svitlanamozharovska.ticktacktoe;

import android.content.Intent;
import android.media.Image;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        final ImageXO theme = SettingsHolder.getInstance().getTheme();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundResource(theme.background);
//        TextView textView = (TextView) findViewById(R.id.settingText);
//        textView.setTextColor(theme.textColor);
    }

    public void firstButton(View view) {

        Button button1 = (Button) findViewById(R.id.button1);
        int id = view.getId() - button1.getId();
        ImageXO xo = ImageXO.values()[id];

        SettingsHolder.getInstance().setTheme(xo);
        final ImageXO theme = SettingsHolder.getInstance().getTheme();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundResource(theme.background);
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);

    }

}
