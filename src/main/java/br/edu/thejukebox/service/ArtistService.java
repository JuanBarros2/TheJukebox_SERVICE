package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.ArtistInvalidException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private AccountRepository repository;


    public Artist addArtist(Artist artist, String username){
        validateArtist(artist);
        artist = new Artist(artist.getName());
        Account account = repository.findAccountByUser_Email(username);
        if(account != null && !account.getArtistSet().contains(artist)){
            account.getArtistSet().add(artist);
            repository.save(account);
        } else {
            throw new ArtistInvalidException();
        }
        return artist;
    }

    public Iterable<Artist> listAll(String username){
        Account account = repository.findAccountByUser_Email(username);
        return account.getArtistSet();
    }


    private void validateArtist(Artist artist){
        if (artist == null || artist.getName() == null) {
            throw new ArtistInvalidException();
        }
    }
}
