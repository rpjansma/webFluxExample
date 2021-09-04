package controller;

import document.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import services.PlaylistService;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping(value="/playlist")
    public Flux<Playlist> findAllPlaylists() {
        return playlistService.findAll();
    }

    @GetMapping(value="/playlist/{id}")
    public Mono<Playlist> findPlaylistById(@PathVariable String id) {
        return playlistService.findById(id);
    }

    @PostMapping(value="/playlist")
    public Mono<Playlist> savePlaylist(@RequestBody Playlist playlist) {
        return playlistService.save(playlist);
    }


}
