package com.svitlanamozharovska.ticktacktoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity1 extends AppCompatActivity {
    AlertDialog.Builder ad;
    Context context;
    private int counterClicks = 1;

    //int background = R.color.colorWhite;


    int[] field = {0, 0, 0,
                 0, 0, 0,
                 0, 0, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
        final ImageXO theme = SettingsHolder.getInstance().getTheme();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundResource(theme.background);

    }

    public void clickImageButton(View view) {

        int id = view.getId();
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        id -= imageButton1.getId();
        Bundle extras = getIntent().getExtras();

        final ImageXO theme = SettingsHolder.getInstance().getTheme();


        if (counterClicks == 9) {
            endGame(id);
        }

        Log.d("ticktacktoe","***** id = " + id + " *****");
        Log.d("ticktacktoe","||||| counterClicks = " + counterClicks + " |||||");
        ImageButton imageButton = (ImageButton) findViewById(view.getId());
        if (counterClicks % 2 == 0) {
            field[id] = 2;
            imageButton.setImageResource(theme.zero);
        } else {
            field[id] = 1;
            imageButton.setImageResource(theme.cross);
        }
        imageButton.setEnabled(false);
        if (counterClicks > 4) {
            checkWinner(id);
        }
        counterClicks++;
    }

    public void checkWinner(int id) {
        int n;
        Log.d("ticktacktoe","***** Больше 5 нажатий *****");
        n = id - id % 3;
        if (field[n] == field[n + 1] && field[n + 1] == field[n + 2]) {
            Log.d("ticktacktoe","///// Совпадения по горизонтали \\\\\\\\\\");
            endGame(id);
            return;
        }
        n = id % 3;
        if (field[n] == field[n + 3] && field[n + 3] == field[n + 6]) {
            Log.d("ticktacktoe","///// Совпадения по вертикали \\\\\\\\\\");
            endGame(id);
            return;
        }
        if (id == 0 || id == 8 || id == 4) {
            if (field[0] == field[8] && field[8] == field[4]) {
                Log.d("ticktacktoe","///// Совпадения по диагонали ЛевоПраво\\\\\\\\\\");
                endGame(id);
                return;
            }
        }
        if (id == 2 || id == 6 || id == 4) {
            if (field[2] == field[6] && field[6] == field[4]) {
                Log.d("ticktacktoe","///// Совпадения по диагонали ПравоЛево \\\\\\\\\\");
                endGame(id);
            }
        }
    }

    public void endGame(int currentStep) {

        context = MainActivity1.this;
        ad = new AlertDialog.Builder(context);
        ad.setTitle("Finish");


        for (int i = 0; i < field.length; i++) {
            Log.d("ticktacktoe", " " + field[i]);
        }
        if (field[currentStep] == 1) {
            ad.setMessage("Win X");
        } else if (field[currentStep] == 2) {
            ad.setMessage("Win O");
        } else {
            ad.setMessage("Dead Heat");
        }

        ad.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                finish();
                Intent myIntent = new Intent(MainActivity1.this, MainActivity1.class);
                startActivity(myIntent);

            }
        });
        ad.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Intent myIntent = new Intent(MainActivity1.this, FirstActivity.class);
                startActivity(myIntent);
            }
        });
        ad.setCancelable(false);
        ad.show();

        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        int id = imageButton1.getId();
        for (int i = 0; i < 9; i++) {
            ImageButton imageButton = (ImageButton) findViewById(id + i);
            imageButton.setEnabled(false);
        }
    }
}
