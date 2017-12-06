package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.DuplicateAccountException;
import br.edu.thejukebox.exception.UserNotFoundException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.repository.AccountRepository;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private BCryptPasswordEncoder crypt;

    public void registerAccount(Account account) throws DuplicateAccountException {
        if (repository.existsDistinctByEmail(account.getEmail())){
            throw new DuplicateAccountException();
        } else {
            account.setPassword(crypt.encode(account.getPassword()));
            repository.save(account);
        }
    }


    private void validateUser(Account account) {
        String userId = account.getUsername();
        this.repository
                .findAccountByUsername(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
