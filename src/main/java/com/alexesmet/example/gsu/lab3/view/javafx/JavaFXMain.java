package com.alexesmet.example.gsu.lab3.view.javafx;

import com.alexesmet.example.gsu.lab3.model.NoteModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;

public class JavaFXMain extends Application {

    private ObservableList<NoteModel> noteArray = FXCollections.observableArrayList();
    private Stage primaryStage;

    public JavaFXMain() {
    }

    public ObservableList<NoteModel> getNoteArray() {
        return noteArray;
    }

    @Override
    public void start(Stage stage) throws IOException {

        this.primaryStage = stage;

        FXMLLoader loader = new FXMLLoader();
        URL location = getClass().getResource("/fxml/MainActivity.fxml");
        loader.setLocation(location);

        Parent root = loader.load();

        // Give the controller access to the main app.
        MainActivityController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root, 640, 510);

        stage.setTitle("FicusNotes GUI");
        stage.setMinHeight(200);
        stage.setMinWidth(500);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Opens a dialog to create a new note
     * @return the created person, null if user clicked "Cancell"
     */
    public NoteModel showCreateActivity() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFXMain.class.getResource("/fxml/CreateActivity.fxml"));
            Parent page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create Note");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            CreateActivityController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.getToCreate();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void showEasterEgg() {
        Parent rootPane;


        try {
            FileInputStream file = new FileInputStream("picture.png");
            Image image = new Image(file);
            ImageView imageView = new ImageView(image);
            rootPane = new HBox(imageView);

        } catch (FileNotFoundException e) {
            rootPane = new HBox(new Label("Can not open picture for you"));

            e.printStackTrace();
        }

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Easter Egg");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(rootPane);
        dialogStage.setScene(scene);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }

    public void start() {
        launch();
    }

}