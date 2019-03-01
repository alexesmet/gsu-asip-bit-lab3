package com.alexesmet.example.gsu.lab3;

import com.alexesmet.example.gsu.lab3.database.NotesDatabase;
import com.alexesmet.example.gsu.lab3.view.cli.ConsoleInterface;

public class Main {
    public static void main(String[] args) {
        new ConsoleInterface(new NotesDatabase()).start();
    }
}
