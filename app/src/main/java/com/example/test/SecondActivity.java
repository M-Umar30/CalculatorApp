package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        TextView welcomeMessage = findViewById(R.id.welcomeText);
        welcomeMessage.setText("Welcome " + userName + "!");
    }
}
