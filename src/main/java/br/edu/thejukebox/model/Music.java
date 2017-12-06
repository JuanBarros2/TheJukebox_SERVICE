package br.edu.thejukebox.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_Music")
public class Music {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Artist artist;
    private Integer year;
    private String duration;

    public Music(){

    }
}
