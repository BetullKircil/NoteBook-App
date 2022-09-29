package com.betulkircil.notebookapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView textTitle;
    TextView note;
    String storedNote;
    String storedNoteText;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textTitle = findViewById(R.id.textView3);
        note = findViewById(R.id.textView2);

        sharedPreferences = this.getSharedPreferences("com.betulkircil.notebookapp", Context.MODE_PRIVATE);
        Intent intent = getIntent();
        storedNote = intent.getStringExtra("storedNote");
        storedNoteText = sharedPreferences.getString("storedNote", "");
        note.setText(storedNote);
    }

    public void back(View view){
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }
    public void delete(View view){
        if(!storedNote.matches("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Delete");
            alert.setMessage("Are you sure?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sharedPreferences.edit().remove("storedNote").apply();
                    Toast.makeText(MainActivity3.this, "Note deleted", Toast.LENGTH_SHORT).show();
                    note.setText("Note deleted");
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity3.this, "Note will not be deleted", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
        else{
            Toast.makeText(this, "Note is already deleted", Toast.LENGTH_LONG).show();
        }
    }
}