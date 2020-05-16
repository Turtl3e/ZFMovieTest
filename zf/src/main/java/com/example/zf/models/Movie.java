package com.example.zf.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movie extends Piece {

    @NotNull
    private String title;
    private String description;
    private String posterUrl;
    private String director; //TODO: Should be a class
    private String genre; //TODO: Should be a list of strings or a class
    private String countryOfProduction;

    @ManyToMany
    public Set<Actor> actors= new HashSet<Actor>();

}

