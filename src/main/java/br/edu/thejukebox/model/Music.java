package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Music {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    @OneToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    private Integer year;
    private String duration;

    public Music(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        if (!id.equals(music.id)) return false;
        if (!name.equals(music.name)) return false;
        return album.equals(music.album);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + album.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }



}
