package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    private String photo;
    private Byte rating;
    private Boolean favorite;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Music lastMusic;

    public Artist(){
        this.name = "";
        this.photo = "";
        this.rating = 0;
        this.favorite = false;
        this.lastMusic = null;
    }

    public Artist(String name) {
        this();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        return name.equals(artist.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public Music getLastMusic() {
        return lastMusic;
    }

    public void setLastMusic(Music lastMusic) {
        this.lastMusic = lastMusic;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Byte getRating() {
        return rating;
    }
}
