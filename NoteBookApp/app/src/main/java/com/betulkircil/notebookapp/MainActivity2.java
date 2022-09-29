package com.betulkircil.notebookapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    EditText editText;
    SharedPreferences sharedPreferences;
    String storedNote;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editTextMultiLine);
        textView = findViewById(R.id.textview);


        sharedPreferences = this.getSharedPreferences("com.betulkircil.notebookapp", Context.MODE_PRIVATE);
        storedNote = sharedPreferences.getString("note", "");

        if(!storedNote.matches("")){
            editText.setText(storedNote);
        }
    }

    public void save(View view){
        String note = editText.getText().toString();
        if(!note.matches("")){
            sharedPreferences.edit().putString("note", note).apply();
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please enter your note!", Toast.LENGTH_LONG).show();
        }
    }

    public void update(View view){
        String note = editText.getText().toString();
        if(!note.matches("")){
            sharedPreferences.edit().putString("note", note).apply();
            Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please enter your note!", Toast.LENGTH_LONG).show();
        }
    }

    public void show(View view){
        if (!storedNote.matches("")) {
            intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("storedNote", storedNote);
            startActivity(intent);
        }
    }

    public void showNote(View view){
        if (!storedNote.matches("")) {
            intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("storedNote", storedNote);
            startActivity(intent);
        }
    }
}