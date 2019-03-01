package com.alexesmet.example.gsu.lab3.view.javafx;

import com.alexesmet.example.gsu.lab3.model.NoteModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateActivityController {

    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentField;
    @FXML
    private Button okButton;

    private Stage dialogStage;

    private NoteModel toCreate;

    @FXML
    private void initialize() {
        okButton.setDisable(true);
        titleField.textProperty().addListener(
                (observable, oldValue, newValue) -> okButton.setDisable(newValue.isEmpty())
        );
    }



    @FXML
    private void handleConfirmButton() {
        if (!titleField.getText().isEmpty()){
            toCreate = new NoteModel(
                    titleField.getText(),
                    contentField.getText()
            );
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        toCreate = null;
        dialogStage.close();
    }


    public NoteModel getToCreate() {
        return toCreate;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
