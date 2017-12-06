package br.edu.thejukebox.rest;

import br.edu.thejukebox.model.User;
import br.edu.thejukebox.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;


    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public void registerAccount(@RequestBody User user){
        service.registerAccount(user);
    }

}
