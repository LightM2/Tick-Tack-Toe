package com.svitlanamozharovska.ticktacktoe;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final ImageXO theme = SettingsHolder.getInstance().getTheme();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundResource(theme.background);
//        TextView textView = (TextView) findViewById(R.id.nameGame);
//        textView.setTextColor(theme.textColor);
//        Button button1 = (Button) findViewById(R.id.onePlayerButton);
//        Button button2 = (Button) findViewById(R.id.twoPlayerButton);
        ImageButton button3 = (ImageButton) findViewById(R.id.settingButton);
//        button1.setTextColor(theme.textColor);
//        button2.setTextColor(theme.textColor);
        button3.setImageResource(theme.brush);

    }

    public void onePlayer(View view) {
        Log.d("ticktacktoe","OnePlayerButton click");
        Intent intent = new Intent(FirstActivity.this,MainActivity2.class);

        startActivity(intent);
    }

    public void twoPlayer(View view) {
        Log.d("ticktacktoe","TwoPlayerButton click");
        Intent intent = new Intent(FirstActivity.this,MainActivity1.class);

        startActivity(intent);
    }

    public void setting(View view) {
        Log.d("ticktacktoe","Setting click");
        Intent intent = new Intent(FirstActivity.this,SettingActivity.class);
        startActivity(intent);
    }
}
