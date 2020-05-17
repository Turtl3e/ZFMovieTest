package com.example.zf.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long actorId;
    private String firstName;
    private String secondName;
    private Date born;
    private String placeOfBirth;
    private String description;

    @ManyToMany(mappedBy = "actors")
    List<Movie> movies;
}
