package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateMusicException extends RuntimeException{

    public DuplicateMusicException(){
        super("Já existe essa música no álbum");
    }
}
