package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_Album")
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "album")
    private Set<Music> musicSet;
    private String name;

    public Album(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (!id.equals(album.id)) return false;
        return name.equals(album.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
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
