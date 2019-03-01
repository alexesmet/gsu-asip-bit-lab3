package com.alexesmet.example.gsu.lab3.service.converter;

import com.alexesmet.example.gsu.lab3.entity.Note;
import com.alexesmet.example.gsu.lab3.model.NoteModel;

public class NoteConverter implements Converter<Note, NoteModel> {

    public  Note convert(NoteModel noteModel) {
        Note note = new Note(noteModel.getTitle(), noteModel.getContent());
        note.setCreationDate(noteModel.getCreationDate());
        return note;
    }

    public  NoteModel convert(Note note) {
        return new NoteModel(
                note.getTitle(),
                note.getContent(),
                note.getCreationDate()
        );
    }
}
