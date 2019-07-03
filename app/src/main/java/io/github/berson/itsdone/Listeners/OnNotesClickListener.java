package io.github.berson.itsdone.Listeners;

import io.github.berson.itsdone.Models.NoteCreate.NotesCreate;
import io.github.berson.itsdone.Models.Notes.Nota;

public interface OnNotesClickListener {
    void onItemClick(Nota item);
}
