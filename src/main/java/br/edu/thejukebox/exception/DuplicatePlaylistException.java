package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatePlaylistException extends RuntimeException {
    public DuplicatePlaylistException(){
        super("Essa playlist já existe");
    }
}
