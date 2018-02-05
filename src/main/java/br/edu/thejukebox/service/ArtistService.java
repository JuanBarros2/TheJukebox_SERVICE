package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.ArtistInvalidException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Consumer;

@Service
public class ArtistService {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private ArtistRepository artistRepository;

    public Artist addArtist(Artist artist, String username){
        validateArtist(artist);
        String photo = artist.getPhoto();
        artist = new Artist(artist.getName());
        artist.setPhoto(photo);
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

    public Artist updateArtist(String email, Artist newer){
        validateArtist(newer);
        Account account = repository.findAccountByUser_Email(email);
        if(account != null && account.getArtistSet().contains(newer)){
            Artist artist = null;
            for(Artist aux : account.getArtistSet()) {
                if (aux.getName().equals(newer.getName())){
                    artist = aux;
                    break;
                }
            }

            if (artist != null){
                artist.setFavorite(newer.getFavorite() != null ? newer.getFavorite() : artist.getFavorite());
                artist.setRating(newer.getRating() != null ? newer.getRating(): artist.getRating());
                artist.setLastMusic(newer.getLastMusic() != null ? newer.getLastMusic(): artist.getLastMusic());
                //TODO Realizar validação da música
                repository.save(account);
            }

        } else {
            throw new ArtistInvalidException();
        }
        return newer;
    }
}
