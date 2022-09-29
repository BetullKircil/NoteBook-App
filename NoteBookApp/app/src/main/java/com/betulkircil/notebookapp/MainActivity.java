package com.betulkircil.notebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText editTextPersonName;
    EditText editTextPassword;
    EditText editTextEmail;
    TextView textView;
    Typeface tf1;

    String storedName;
    String storedPassword;
    String storedEmail;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.betulkircil.notebookapp", Context.MODE_PRIVATE);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        textView = findViewById(R.id.textview);
        tf1 = Typeface.createFromAsset(getAssets(), "fonts/mono.ttf");

        storedName = sharedPreferences.getString("name","");
        storedPassword = sharedPreferences.getString("password", "");
        storedEmail = sharedPreferences.getString("email", "");

        editTextPassword.setTypeface(tf1);
        editTextEmail.setTypeface(tf1);
        editTextPersonName.setTypeface(tf1);
    }
    public void register(View view){
        String name = editTextPersonName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if(!name.matches("") && !password.matches("") && !email.matches("")){
            sharedPreferences.edit().putString("name", name).apply();
            sharedPreferences.edit().putString("email", email).apply();
            sharedPreferences.edit().putString("password", password).apply();
            Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please enter your whole infos", Toast.LENGTH_SHORT).show();
        }
    }

    public void login(View view){
        if(!storedName.matches("") && !storedEmail.matches("") && !storedPassword.matches("")){
            intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please register before", Toast.LENGTH_SHORT).show();
        }
    }
}