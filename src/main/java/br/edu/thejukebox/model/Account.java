package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private User user;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Album> albumSet;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Artist> artistSet;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Artist> favorite;

    public Account(){
        this.albumSet = new HashSet<>();
        this.artistSet = new HashSet<>();
        this.favorite = new HashSet<>();
    }

    public Account(User user){
        this();
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        return user.equals(account.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    public User getUser() {
        return user;
    }

    public Set<Artist> getFavorite() {
        return favorite;
    }

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public Set<Artist> getArtistSet() {
        return artistSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }

    public void setArtistSet(Set<Artist> artistSet) {
        this.artistSet = artistSet;
    }
}
