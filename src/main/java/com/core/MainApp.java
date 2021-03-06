package com.core;

import com.controllers.playlist.PlaylistsList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** Main Application Class */
public class MainApp extends Application {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    @Getter
    public static PlaylistsList playlistsList;

    private double mouseDragDeltaX = 0;
    private double mouseDragDeltaY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        log.info("Starting JavaFXMusicPlayer");

        String fxmlFile = "/fxml/MusicPlayerGUI.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        BorderPane rootNode = loader.load();

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 1520, 900);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        allowDrag(rootNode, stage);
        stage.show();
        playlistsList = new PlaylistsList();
    }

    /**
     * Allow the drag of the window
     * @param node the parent node press
     * @param stage the stage to drag
     */
    protected void allowDrag(Node node, Stage stage) {
        EventHandler<MouseEvent> mousePressedHandler = (MouseEvent event) -> {
            mouseDragDeltaX = node.getLayoutX() - event.getSceneX();
            mouseDragDeltaY = node.getLayoutY() - event.getSceneY();
        };
        WeakEventHandler<MouseEvent> weakMousePressedHandler = new WeakEventHandler<>(mousePressedHandler);
        node.setOnMousePressed(weakMousePressedHandler);

        EventHandler<MouseEvent> mouseDraggedHandler = (MouseEvent event) -> {
            stage.setX(event.getScreenX() + mouseDragDeltaX);
            stage.setY(event.getScreenY() + mouseDragDeltaY);
        };
        WeakEventHandler<MouseEvent> weakMouseDraggedHandler = new WeakEventHandler<>(mouseDraggedHandler);
        node.setOnMouseDragged(weakMouseDraggedHandler);
    }
}
