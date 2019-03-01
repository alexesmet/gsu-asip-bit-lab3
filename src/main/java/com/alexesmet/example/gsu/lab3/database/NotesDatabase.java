package com.alexesmet.example.gsu.lab3.database;

import com.alexesmet.example.gsu.lab3.entity.Note;

import java.util.LinkedList;
import java.util.List;

public class NotesDatabase {
    private List<Note> list = new LinkedList<Note>();

    public void add(Note note) {
        list.add(note);
    }

    public List<Note> getAll() {
        return list;
    }

    public void clear() {
        list.clear();
    }

    public long amount() {
        return list.size();
    }

}
