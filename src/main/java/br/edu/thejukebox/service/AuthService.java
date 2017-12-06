package br.edu.thejukebox.service;

import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> returnDataBase = accountRepository.findAccountByUsername(username);
        if (returnDataBase == null || !returnDataBase.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        Account account = returnDataBase.get();
        return new User(account.getUsername(), account.getPassword(), emptyList());
    }
}