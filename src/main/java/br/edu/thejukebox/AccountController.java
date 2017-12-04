package br.edu.thejukebox;

import br.edu.thejukebox.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountRepository accountRepository;

    @Autowired
    AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void cadastraArtista() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public void listarArtistasPorNome() {
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void recuperarArtistaPorNome(@PathVariable Integer id) {

    }
}
