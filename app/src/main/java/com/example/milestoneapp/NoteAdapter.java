package com.example.milestoneapp;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

	List<Note> notes;

	public NoteAdapter(List<Note> notes) {
		this.notes = notes;
	}

	class ViewHolder extends RecyclerView.ViewHolder{

		TextView title,note,time;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			title = itemView.findViewById(R.id.title);
			note = itemView.findViewById(R.id.note);
			time = itemView.findViewById(R.id.time);
		}
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Note n = notes.get(position);
		holder.title.setText(n.getTitle());
		holder.note.setText(n.getNote());
		holder.time.setText(String.valueOf(n.getTime()));
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlenote,parent,false);
		return new ViewHolder(view);
	}

	@Override
	public int getItemCount() {
		return notes.size();
	}
}
