package com.alexesmet.example.gsu.lab3.view.cli;

import com.alexesmet.example.gsu.lab3.database.NotesDatabase;
import com.alexesmet.example.gsu.lab3.entity.Note;
import com.alexesmet.example.gsu.lab3.view.javafx.JavaFXMain;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInterface {

    private static final String BANNER =
            "   |      ______ _                _   _       _            \n" +
            " .'|'.   |  ____(_)              | \\ | |     | |\n" +
            "/.'|\\ \\  | |__   _  ___ _   _ ___|  \\| | ___ | |_ ___  ___ \n" +
            "| /|'.|  |  __| | |/ __| | | / __| . ` |/ _ \\| __/ _ \\/ __|\n" +
            " \\ |\\/   | |    | | (__| |_| \\__ \\ |\\  | (_) | ||  __/\\__ \\\n" +
            "  \\|/    |_|    |_|\\___|\\__,_|___/_| \\_|\\___/ \\__\\___||___/\n" +
            "   `";


    private static final String HELP = "Available commands (case sensitive): \n" +
            "add [title] [text] -- add new note. Title should be single-word (no spaces). \n" +
            "lst -- list all saved notes. \n" +
            "clr -- delete all notes.\n" +
            "gui -- open GUI.\n" +
            "hlp -- show this help page. \n" +
            "ext -- close application (all notes will be deleted).\n";


    private static Scanner sc = new Scanner(System.in);

    private NotesDatabase db;

    public ConsoleInterface(NotesDatabase db) {
        this.db = db;
    }

    public void start() {
        System.out.println(BANNER);
        System.out.println("Welcome to FicusNotes, console interface. ");
        System.out.println(HELP);

        while (true){
            System.out.print("::: ");
            String command = sc.nextLine();
            String[] args = Arrays.stream(command.split(" "))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);

            switch (args[0]) {
                case "add":
                    if (args.length > 3 )
                        db.add(new Note(args[1], String.join(" ",Arrays.asList(args).subList(2,args.length))));
                    else
                        System.out.println("add [title] [text]");
                    break;
                case "lst":
                    if (args.length == 1) {
                        System.out.println(db.amount() + " notes:");
                        db.getAll().forEach(System.out::println);

                    } else
                        System.out.println("lst has no args");
                    break;
                case "clr":
                    db.clear();
                    break;
                case "gui":
                    System.out.println("WARNING: After you close this windows, app will be fully terminated.");
                    JavaFXMain.main(new String[0]);
                    return;
                case "hlp":
                case "help":
                case "?":
                    System.out.println(HELP);
                    break;
                case "ext":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command: " + args[0] + ". Type \"hlp\" to help.");
            }
            System.out.println("Done.");


        }


    }


}

