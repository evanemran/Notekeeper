package com.evanemran.notekeeper.Listeners;

import androidx.cardview.widget.CardView;

import com.evanemran.notekeeper.Models.Notes;

public interface NoteClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
