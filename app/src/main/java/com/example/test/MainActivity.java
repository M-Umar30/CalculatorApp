 package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void afterClick(View view){
        TextView afterClick = findViewById(R.id.textBeforeClick);
        EditText edtText = findViewById(R.id.nameInput);
        String userName = edtText.getText().toString();
        String welcomeText = "Welcome " + userName + "!";
        afterClick.setText(welcomeText);
        Button btn = findViewById(R.id.textButton);
        btn.setVisibility(View.INVISIBLE);


        TextView userFullName = findViewById(R.id.User_FullName);
        EditText lastName = findViewById(R.id.LastnameInput);
        String fullName = userName + " " + lastName.getText().toString();

        userFullName.setText(fullName);

        TextView userEmail = findViewById(R.id.User_Email);
        EditText emailInput = findViewById(R.id.emailInput);
        String email = emailInput.getText().toString();
        userEmail.setText(email);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", fullName);
        startActivity(intent);


        // TODO: Load different view and pass arguments to it
        // TODO: Make a welcome page for user with their information



    }
}