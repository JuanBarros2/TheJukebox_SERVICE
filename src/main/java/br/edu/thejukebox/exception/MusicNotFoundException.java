package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicNotFoundException extends RuntimeException{
    public MusicNotFoundException(){
        super("Essa música não foi encontrada");
    }
}
