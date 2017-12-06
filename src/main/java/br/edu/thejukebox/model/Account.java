package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_Accounts")
public class Account {
    @Id
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private Set<Album> albumSet;
    @OneToMany
    private Set<Artist> artistSet;

    public Account(){

    }
}
