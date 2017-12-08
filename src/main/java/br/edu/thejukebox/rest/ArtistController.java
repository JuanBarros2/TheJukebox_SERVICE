package br.edu.thejukebox.rest;

import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.model.Music;
import br.edu.thejukebox.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public Artist addArtist(@RequestBody Artist artist, Principal principal){
        return service.addArtist(artist, principal.getName());
    }

    @GetMapping(value = "/list")
    public Iterable<Artist> listAll(Principal principal){
        return service.listAll(principal.getName());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/favorite")
    public boolean favorite(Principal principal, @RequestBody Artist artist){
        artist = service.updateArtist(principal.getName(), artist);
        return artist.getFavorite();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/rating")
    public Artist ranking(Principal principal, @RequestBody Artist artist){
        return service.updateArtist(principal.getName(), artist);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/lastMusic")
    public Music changeLastMusic(Principal principal, @RequestBody Artist artist){
        artist = service.updateArtist(principal.getName(), artist);
        return artist.getLastMusic();
    }
}
