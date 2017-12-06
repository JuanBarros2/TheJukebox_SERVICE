package br.edu.thejukebox.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_Artist")
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String photo;
    private Byte rating;
    @OneToOne
    private Music lastMusic;

    public Artist(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (!id.equals(artist.id)) return false;
        return name.equals(artist.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public void setLastMusic(Music lastMusic) {
        this.lastMusic = lastMusic;
    }
}
