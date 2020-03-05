package com.example.milestoneapp;

import com.reactiveandroid.Model;
import com.reactiveandroid.annotation.Column;
import com.reactiveandroid.annotation.PrimaryKey;
import com.reactiveandroid.annotation.Table;

@Table(name = "Note", database = Appdatabase.AppDatabase.class)
public class Note extends Model {

	@PrimaryKey
	long id;

	@Column
	String time;

	@Column
	String title;

	@Column
	String note;

	public Note(){

	}

	public Note(String  time, String title, String note) {
		this.time = time;
		this.title = title;
		this.note = note;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {

		this.time = time;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {

		this.title = title;
	}


	public String getNote() {

		return note;
	}


	public void setNote(String note) {

		this.note = note;
	}
}

