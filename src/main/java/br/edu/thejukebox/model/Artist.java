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
}
