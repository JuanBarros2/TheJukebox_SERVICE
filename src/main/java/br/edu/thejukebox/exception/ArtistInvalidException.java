package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArtistInvalidException extends RuntimeException{

    public ArtistInvalidException (){
        super("Esse artista contém irregularidades");
    }

    public ArtistInvalidException (String message){
        super("Esse artista contém irregularidades");
    }
}
