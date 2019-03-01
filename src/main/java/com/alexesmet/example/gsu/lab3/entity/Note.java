package com.alexesmet.example.gsu.lab3.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Note implements EntityInterface {

    private String title;
    private String content;
    private Date creationDate;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationDate = new Date();
    }

    @Override
    public String toString() {
        return String.format("%15s: %s",title,content);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
