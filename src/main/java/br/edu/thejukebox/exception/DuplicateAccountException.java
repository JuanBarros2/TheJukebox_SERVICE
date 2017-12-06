package br.edu.thejukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateAccountException extends Exception {

    public DuplicateAccountException() {
        super("Já existe um usuário cadastrado nessa conta");
    }
}
