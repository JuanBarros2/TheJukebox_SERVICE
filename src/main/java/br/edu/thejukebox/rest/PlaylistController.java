package br.edu.thejukebox.rest;

import br.edu.thejukebox.model.Music;
import br.edu.thejukebox.model.Playlist;
import br.edu.thejukebox.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add/music")
    public Music addMusic(Principal principal, @RequestBody Playlist playlist){
        return service.addMusic(principal.getName(), playlist);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public Playlist addPlaylist(Principal principal, @RequestBody Playlist playlist){
        return service.addPlaylist(principal.getName(), playlist);
    }

    @DeleteMapping(value = "/remove")
    public Playlist removePlaylist(Principal principal, @RequestBody Playlist playlist){
        return service.removePlaylist(principal.getName(), playlist);
    }

    @DeleteMapping(value = "/remove/music")
    public Music removeMusic(Principal principal, @RequestBody Playlist playlist ){
        return service.removeMusic(principal.getName(), playlist);
    }

}

