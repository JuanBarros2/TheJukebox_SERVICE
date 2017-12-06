package br.edu.thejukebox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String username;
    private String password;

    public User() {
    }
}