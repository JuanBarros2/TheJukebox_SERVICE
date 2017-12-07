package br.edu.thejukebox.rest;

import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService service;

    @PostMapping(value = "/add")
    public Artist addArtist(@RequestBody Artist artist, Principal principal){
        return service.addArtist(artist, principal.getName());
    }

    @GetMapping(value = "/list")
    public Iterable<Artist> listAll(Principal principal){
        return service.listAll(principal.getName());
    }
}
