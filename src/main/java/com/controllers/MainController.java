package com.controllers;

import com.controllers.playlist.PlayListTreeViewController;
import com.controllers.playlist.PlaylistButtonsController;
import javafx.fxml.FXML;
import lombok.Getter;

@Getter
public class MainController {
    @FXML private PlaylistButtonsController playlistButtonsController;
    @FXML private PlayListTreeViewController playlistTreeViewController;

    /**
     * Inject controllers to other controllers
     */
    public void initialize(){
        playlistButtonsController.setPlayListTreeViewController(playlistTreeViewController);
    }
}
