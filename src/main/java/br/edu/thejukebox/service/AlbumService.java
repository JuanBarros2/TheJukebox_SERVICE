package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.ArtistInvalidException;
import br.edu.thejukebox.exception.DuplicateMusicException;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.Album;
import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.model.Music;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;

@Service
public class AlbumService {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private AlbumRepository albumRepository;

    public Music addMusic(String email, Album album) {
        validadeAlbum(album);
        Music music = album.getMusicSet().iterator().next();
        validadeMusic(music);
        music.setAlbum(album);
        album.setMusicSet(new HashSet<>());
        Account account = repository.findAccountByUser_Email(email);

        if(account != null && account.getArtistSet().contains(music.getArtist())){
            album = getAlbumFromAccount(music, account);
            if (album == null) {
                account.getAlbumSet().add(music.getAlbum());
                album = music.getAlbum();
            }
            if(album.getMusicSet().contains(music)){
                throw new DuplicateMusicException();
            }
            album.getMusicSet().add(music);
            account.getAlbumSet().add(album);
            repository.save(account);
        } else {
            throw new ArtistInvalidException("Não foi encontrado esse artista para essa conta");
        }
        return music;
    }

    private Album getAlbumFromAccount(Music music, Account account) {
        Album album = null;
        Iterator<Album> iterator = account.getAlbumSet().iterator();

        while (iterator.hasNext()) {
            Album aux = iterator.next();
            if(aux.equals(music.getAlbum())) {
                album = aux;
                break;
            }
        }
        return album;
    }

    private void validadeAlbum(Album album){
        if(album == null || album.getName() == null || album.getName().isEmpty()){
            throw  new IllegalArgumentException("Album inválido");
        }
    }
    private void validadeMusic(Music music) {
        if(music == null || music.getName()== null || music.getDuration()== null || music.getYear()== null || music.getArtist()== null)
            throw new IllegalArgumentException("Música não respeita ao formato do sistema");
    }

    public Iterable<Album> listAll(String username){
        Account account = repository.findAccountByUser_Email(username);
        return account.getAlbumSet();
    }

}
