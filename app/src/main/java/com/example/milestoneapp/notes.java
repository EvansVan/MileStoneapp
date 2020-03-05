package com.example.milestoneapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.reactiveandroid.ReActiveAndroid;
import com.reactiveandroid.ReActiveConfig;
import com.reactiveandroid.internal.database.DatabaseConfig;
import com.reactiveandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class notes extends AppCompatActivity {

	RecyclerView notesTask;
	FloatingActionButton newNote;
	List<Note> notes;
	NoteAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notes);


		DatabaseConfig appDatabase = new DatabaseConfig
						.Builder(Appdatabase.AppDatabase.class)
						.addModelClasses(Note.class)
						.build();

		ReActiveAndroid
						.init(new ReActiveConfig.Builder(this)
										.addDatabaseConfigs(appDatabase)
										.build());

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		final String dateString = formatter.format(new Date(System.currentTimeMillis()));

		notesTask = findViewById(R.id.notesTask);
		newNote = findViewById(R.id.newNote);

		notes = Select.from(Note.class).fetch();
		notesTask.setLayoutManager(new LinearLayoutManager(notes.this));
		adapter = new NoteAdapter(notes);
		notesTask.setAdapter(adapter);


		newNote.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(notes.this);
				dialog.setContentView(R.layout.newnote);

				final EditText title = dialog.findViewById(R.id.title);
				final EditText note = dialog.findViewById(R.id.note);
				Button save = dialog.findViewById(R.id.save_note);

				save.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						String titleString = title.getText().toString();
						String noteString = note.getText().toString();
						//save the note

						Note note = new Note(dateString,titleString, noteString);
						note.save();
						startActivity(new Intent(notes.this, notes.class));
					}
				});

				dialog.show();

			}
		});

	}
}