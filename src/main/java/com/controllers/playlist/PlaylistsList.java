package com.controllers.playlist;

import com.types.Playlist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistsList {

    private List<Playlist> playlists = new ArrayList<>();

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public void removePlaylist(int index){
        playlists.remove(index);
    }
}
