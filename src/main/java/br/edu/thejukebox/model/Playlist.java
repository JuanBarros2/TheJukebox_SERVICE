package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Playlist {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @ManyToMany
    private Set<Music> musics;
    private String name;

    public Playlist(){
        this.musics = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        return name != null ? name.equals(playlist.name) : playlist.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }

    public Set<Music> getMusics() {

        return musics;
    }

    public String getName() {
        return name;
    }
}
