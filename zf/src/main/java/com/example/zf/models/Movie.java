package com.example.zf.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@getter @setter @ToString @EqualsAndHashCode @RequriedArgsConstructor
@Entity
@RequiredArgsConstructor
@Data
@Accessors(chain = true)
public class Movie extends Piece {

    @NotNull
    private String title;
    private String description;
    private String posterUrl;
    private String director; //TODO: Should be a class
    private String genre; //TODO: Should be a list of strings or a class
    private String countryOfProduction;

    @Builder
    public Movie(Long pieceId, LocalDate releaseDate, String title, String description, String posterUrl, String director, String genre, String countryOfProduction) {
        super(pieceId, releaseDate);
        this.title = title;
        this.description = description;
        this.posterUrl = posterUrl;
        this.director = director;
        this.genre = genre;
        this.countryOfProduction = countryOfProduction;
    }

    public void updateMovie(Movie updatedMovie){
        this.setTitle(updatedMovie.getTitle())
        .setDescription(updatedMovie.getDescription())
        .setCountryOfProduction(updatedMovie.getCountryOfProduction())
        .setDirector(updatedMovie.getDirector())
        .setGenre(updatedMovie.getGenre())
        .setPosterUrl(updatedMovie.getPosterUrl())
        .setReleaseDate(updatedMovie.getReleaseDate());
    }

    public void removeActor(Actor actorToRemove){
        actors.remove(actorToRemove);
    }
    public boolean hasActor(Actor actor){
        return actors.contains(actor);
    }

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonManagedReference
    public List<Actor> actors;

}

