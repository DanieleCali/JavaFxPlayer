package com.controllers.playlist;

import com.core.MainApp;
import com.types.Playlist;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PlaylistButtonsController {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    @FXML private Button addPlaylistBtn;
    @FXML private Button removePlaylistBtn;

    @Getter
    @Setter
    @FXML private PlayListTreeViewController playListTreeViewController;

    /**
     * Adds a playlist to the application
     */
    public void addPlaylist(){
        Playlist playlist = new Playlist("New Playlist", new ArrayList<>());
        TreeItem<String> treeItemPlaylist = new TreeItem<>("New Playlist");
        playListTreeViewController.getPlaylistTreeView().getRoot().getChildren().add(treeItemPlaylist);
        log.info("Add playlist button pressed");
    }

    /**
     * Removes the selectioned playlist from the application
     */
    public void removePlaylist(){
        TreeItem<String> root = playListTreeViewController.getPlaylistTreeView().getRoot();
        int index = playListTreeViewController.getPlaylistTreeView().getSelectionModel().getSelectedIndex();
        log.info("index: " + index);
        if (index <= root.getChildren().size() && index > 0)  root.getChildren().remove(index-1);
        log.info("Remove playlist button pressed");
    }
}
