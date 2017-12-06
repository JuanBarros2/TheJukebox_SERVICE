package br.edu.thejukebox.rest;

import br.edu.thejukebox.exception.DuplicateAccountException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerAccount(@RequestBody Account account) throws DuplicateAccountException {
        service.registerAccount(account);
    }


}