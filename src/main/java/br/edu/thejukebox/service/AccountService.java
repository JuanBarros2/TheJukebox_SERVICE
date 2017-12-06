package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.DuplicateAccountException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.User;
import br.edu.thejukebox.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(User user) {

        this.validateField(user);
        if (accountRepository.findAccountByUser_Email(user.getEmail()) == null){

            Account account = new Account(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            accountRepository.save(account);
        } else {
            throw new DuplicateAccountException();
        }
    }

    private void validateField(User user) {
        if (user == null){
            throw new IllegalArgumentException("O usuário está incorreto");
        }
    }
}
