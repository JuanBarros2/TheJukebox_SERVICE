package br.edu.thejukebox.rest;

import br.edu.thejukebox.model.Album;
import br.edu.thejukebox.model.Music;
import br.edu.thejukebox.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add/music")
    public Music addMusic(Principal principal, @RequestBody Music music){
        return service.addMusic(principal.getName(), music);
    }

    @GetMapping(value = "/list")
    public Iterable<Album> listAll(Principal principal){
        return service.listAll(principal.getName());
    }
}
