package com.alexesmet.example.gsu.lab3.view.javafx;

import com.alexesmet.example.gsu.lab3.model.NoteModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainActivityController {

    @FXML
    private TableView<NoteModel> noteTable;
    @FXML
    private TableColumn<NoteModel, String> titleColumn;
    @FXML
    private TableColumn<NoteModel, String> createdColumn;
    @FXML
    private Label titleLabel;
    @FXML
    private Label contentLabel;
    @FXML
    private Button deleteButton;
    @FXML
    private Button createButton;

    // Reference to the main application.
    private JavaFXMain  mainApp;
    private int deleteButtonPressingSpree = 0;


    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MainActivityController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        createdColumn.setCellValueFactory(cellData -> cellData.getValue().creationDateStringProperty());
        //clean details
        showNoteDetails(null);

        noteTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showNoteDetails(newValue);
                    deleteButtonPressingSpree = 0;
                });

    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {

        int selectedIndex = noteTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
            noteTable.getItems().remove(selectedIndex);
        else
            deleteButtonPressingSpree++;

        if (deleteButtonPressingSpree > 10 ) {
            deleteButtonPressingSpree = 0;
            mainApp.showEasterEgg();
        }
    }

    /**
     * Called when Create button is pressed.
     */
    @FXML
    private void handleCreateButton() {
        NoteModel noteModel = mainApp.showCreateActivity();
        if (noteModel != null)
            mainApp.getNoteArray().add(noteModel);
    }

    private void showNoteDetails(NoteModel note){
        if (note != null) {
            titleLabel.setText( note.getTitle());
            contentLabel.setText( note.getContent());
        } else {
            titleLabel.setText("");
            contentLabel.setText("");
        }
    }


    public void setMainApp(JavaFXMain  mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        noteTable.setItems(mainApp.getNoteArray());
    }



}
