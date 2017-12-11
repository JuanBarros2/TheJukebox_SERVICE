package br.edu.thejukebox.service;

import br.edu.thejukebox.exception.*;
import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.Music;
import br.edu.thejukebox.model.Playlist;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class PlaylistService {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private MusicRepository musicRepository;

    public Music addMusic(String email, Playlist playlist) {

        validadePlaylist(playlist);
        Account account = repository.findAccountByUser_Email(email);
        Music music = playlist.getMusicSet().iterator().next();
        if(account != null){
            music = musicRepository.findFirstByName(music.getName());
            playlist = getPlaylistFromAccount(playlist, account);
            if (playlist != null) {
                if(music == null){
                    throw new MusicNotFoundException();
                }
                if(playlist.getMusicSet().contains(music)){
                    throw new DuplicateMusicException();
                }
                playlist.getMusicSet().add(music);
                account.getPlaylistSet().add(playlist);
                repository.save(account);
            }else {
                throw new PlaylistNotFountException();
            }

        } else {
            throw new UserNotFoundException("Não foi possível encontrar esse usuário");
        }
        return music;
    }

    private Playlist getPlaylistFromAccount(Playlist playlist, Account account) {
        Playlist result = null;
        Iterator<Playlist> iterator = account.getPlaylistSet().iterator();

        while (iterator.hasNext()) {
            Playlist aux = iterator.next();
            if(aux.equals(playlist)) {
                result = aux;
                break;
            }
        }
        return result;
    }

    private void validadePlaylist(Playlist playlist) {
        if(playlist == null || playlist.getName()== null || playlist.getMusicSet() == null || playlist.getMusicSet().size() != 1 )
            throw new IllegalArgumentException("Playlist não respeita ao formato do sistema");
    }

    public Playlist addPlaylist(String email, Playlist album) {
        Account account = repository.findAccountByUser_Email(email);

        if(account != null){
            boolean alreadyExist = !account.getPlaylistSet().add(album);
            if(alreadyExist){
                throw new DuplicatePlaylistException();
            }else{
                repository.save(account);
            }
        } else {
            throw new UserNotFoundException("Não foi possível encontrar esse usuário");
        }
        return album;
    }

    public Playlist removePlaylist(String email, Playlist album) {

        Account account = repository.findAccountByUser_Email(email);

        if (account != null){
            if(account.getPlaylistSet().remove(album)){
                repository.save(account);
            }else{
                throw new PlaylistNotFountException();
            }
        } else {
            throw new UserNotFoundException("Não foi possível encontrar esse usuário");
        }
        return album;

    }

    public Music removeMusic(String email, Playlist playlist) {

        validadePlaylist(playlist);
        Account account = repository.findAccountByUser_Email(email);
        Music music = playlist.getMusicSet().iterator().next();
        if(account != null){
            playlist = getPlaylistFromAccount(playlist, account);
            if (playlist != null) {
                if(playlist.getMusicSet().remove(music)){
                    repository.save(account);
                }else{
                    throw new MusicNotFoundException();
                }
            }else {
                throw new PlaylistNotFountException();
            }

        } else {
            throw new UserNotFoundException("Não foi possível encontrar esse usuário");
        }
        return music;
    }
}
