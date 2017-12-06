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
    @OneToMany
    private Set<Music> musicSet;
    private String name;

}
