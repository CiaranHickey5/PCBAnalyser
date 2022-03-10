package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private MenuItem btnOpenImage;

    @FXML
    private ImageView imageViewFile;

    @FXML
    private TextArea textAreaFile;

    FileChooser fileChooser = new FileChooser();

    @FXML
    void handleOpenImage(ActionEvent event) {
        fileChooser.setTitle("My File Chooser");

        //Shows open dialog and sets the selected file to file or null if none selected
        File file = fileChooser.showOpenDialog(null);

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));

        if(file!=null) {
            //Returns the absolute path in the text area
            textAreaFile.appendText(file.getAbsolutePath());
            imageViewFile.setImage(new Image(file.toURI().toString()));
        } else{
            System.out.println("Invalid file");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("C:\\Users\\ciara\\IdeaProjects\\Assignment1\\src\\main\\resources\\com\\example\\assignment1"));
    }
}