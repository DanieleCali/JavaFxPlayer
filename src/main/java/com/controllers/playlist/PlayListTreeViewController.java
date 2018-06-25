package com.controllers.playlist;

import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import lombok.Getter;

@Getter
public class PlayListTreeViewController {
    @FXML private TreeView<String> playlistTreeView;
}
