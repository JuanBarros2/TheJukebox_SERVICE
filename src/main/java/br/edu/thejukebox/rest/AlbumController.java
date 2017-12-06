package br.edu.thejukebox.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @RequestMapping(value = "/te", method = RequestMethod.GET)
    public void ve(){

    }
}
