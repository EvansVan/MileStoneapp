package com.example.milestoneapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class home extends AppCompatActivity {

	ImageView africa;
	TextView dateText;
	Button addNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		final SharedPreferences preferences = getSharedPreferences( "user_login",MODE_PRIVATE);
		africa = findViewById(R.id.imageView);
		dateText = findViewById(R.id.dateText);
		addNote = findViewById(R.id.addNote);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = formatter.format(new Date(System.currentTimeMillis()));

		String userName = preferences.getString("user",null);
		dateText.setText("Welcome " + userName + " working " + dateString);


		africa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				africa.animate().rotationBy(180).setDuration(3000);
			}
		});

		addNote.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(home.this, notes.class);
				startActivity(intent);
			}
		});

	}
}