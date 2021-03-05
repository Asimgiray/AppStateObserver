package com.example.appstateobserver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnActA , btnActB , btnGetState;
    TextView txtState;
    Activity act;
    Context ctx;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = this;
        ctx = this;

        btnActA = findViewById(R.id.btnActA);
        btnActB = findViewById(R.id.btnActB);
        btnGetState = findViewById(R.id.btnGetState);

        txtState = findViewById(R.id.txtState);
        txtState.setText(getResources().getString(R.string.click_get_current_state));

        btnGetState.setOnClickListener(v -> {
            txtState.setText(MyApp.appStates.toString());
        });

        btnActA.setOnClickListener(v -> {
            intent = new Intent(ctx , ActivityFirst.class);
            openNewActivity(intent);
        });

        btnActB.setOnClickListener(v -> {
          intent = new Intent(ctx , ActivitySecond.class);
          openNewActivity(intent);
        });



    }

    void openNewActivity(Intent intent){
        startActivity(intent);
    }
}