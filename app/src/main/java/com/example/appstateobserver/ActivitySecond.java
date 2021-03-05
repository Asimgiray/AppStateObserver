package com.example.appstateobserver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {

    Button btnCloseAct , btnGetState;
    TextView txtState;

    Activity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        act = this;

        btnCloseAct = findViewById(R.id.btnCloseAct);
        btnGetState = findViewById(R.id.btnGetState);

        txtState = findViewById(R.id.txtState);

        btnGetState.setOnClickListener(v -> {
            txtState.setText(MyApp.appStates.toString());
        });

        btnCloseAct.setOnClickListener(v -> {
            act.finish();
        });
    }
}