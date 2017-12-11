package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaylistNotFountException extends RuntimeException {
    public PlaylistNotFountException(){
        super("Essa playlist não foi encontrada");
    }
}
