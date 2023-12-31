package com.example.notetoself;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ListItemHolder> {

    private List<Note> mNoteList;
    private MainActivity mMainActivity;

    public NoteAdapter(MainActivity mainActivity, List<Note> noteList) {
        mMainActivity = mainActivity;
        mNoteList = noteList;
    }

    @NonNull
    @Override
    public NoteAdapter.ListItemHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ListItemHolder(itemView);
    }




    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.mTitle.setText(note.getTitle());
        // Show the first 15 characters of the actual note
        holder.mDescription.setText(note.getDescription());

        // What is the status of the note?
        if(note.isIdea()){
            holder.mStatus.setText(R.string.idea_text);
        }
        else if(note.isImportant()){
            holder.mStatus.setText(R.string.important_text);
        }
        else if(note.isTodo()){
            holder.mStatus.setText(R.string.todo_text);
        }
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        TextView mDescription;
        TextView mStatus;

        public ListItemHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.textViewTitle);
            mDescription = (TextView) view.findViewById(R.id.textViewDescription);
            mStatus = (TextView) view.findViewById(R.id.textViewStatus);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mMainActivity.showNote(getAdapterPosition());
        }
    }

}
