package com.alexesmet.example.gsu.lab3.model;

import com.alexesmet.example.gsu.lab3.entity.Note;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteModel implements Model<Note> {
    private final StringProperty title;
    private final StringProperty content;
    private final ObjectProperty<Date> creationDate;

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm");

    public NoteModel(StringProperty title, StringProperty content, ObjectProperty<Date> creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public NoteModel(String title, String content, Date creation) {
        this.title = new SimpleStringProperty(title);
        this.content = new SimpleStringProperty(content);
        this.creationDate = new SimpleObjectProperty<>(creation);
    }

    public NoteModel(String title, String content) {
        this.title = new SimpleStringProperty(title);
        this.content = new SimpleStringProperty(content);
        this.creationDate = new SimpleObjectProperty<>(new Date());
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public Date getCreationDate() {
        return creationDate.get();
    }

    public ObjectProperty<Date> creationDateProperty() {
        return creationDate;
    }

    public StringProperty creationDateStringProperty() {
        return new SimpleStringProperty( FORMAT.format(creationDate.getValue()) );
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate.set(creationDate);
    }


}
