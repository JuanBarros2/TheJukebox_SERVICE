package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Music> musicSet;
    private String name;

    public Album(){
        this.musicSet = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        return name != null ? name.equals(album.name) : album.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusicSet(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }

    public Set<Music> getMusicSet() {

        return musicSet;
    }

    public String getName() {
        return name;
    }
}
