package com.outlook.gonzasosa.basicapp;

import android.app.Activity;
import android.app.admin.DelegatedAdminReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    public static final String ALL = "all";
    TextView WELCOME1, WELCOME2, WELCOME3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_second);

        Intent intent = getIntent();
        if (intent == null) return;

        String NAME = intent.getStringExtra(MainActivity.NAME);
        String LASTNAME = intent.getStringExtra(MainActivity.LASTNAME);
        String AGE = intent.getStringExtra(MainActivity.AGE);
        String ADDRESS = intent.getStringExtra(MainActivity.ADDRESS);

        WELCOME1 = (TextView) findViewById(R.id.welcome_1);
        WELCOME2 = (TextView) findViewById(R.id.welcome_2);
        WELCOME3 = (TextView) findViewById(R.id.welcome_3);

        WELCOME1.setText(NAME + " " + LASTNAME);
        WELCOME2.setText(AGE);
        WELCOME3.setText(ADDRESS);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra(ALL, "Name: " + WELCOME1.getText().toString() + "Age: " + WELCOME2.getText().toString() + "Address " + WELCOME3.getText().toString());
        startActivity(intent);
        this.finish();

    }
}
