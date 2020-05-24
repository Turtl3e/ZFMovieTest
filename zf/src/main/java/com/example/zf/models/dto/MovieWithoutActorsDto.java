package com.example.zf.models.dto;

import com.example.zf.models.Piece;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class MovieWithoutActorsDto extends Piece {
    private String title;
    private String description;
    private String posterUrl;
    private String director; //TODO: Should be a class
    private String genre; //TODO: Should be a list of strings or a class
    private String countryOfProduction;

    @Builder
    public MovieWithoutActorsDto(Long pieceId, LocalDate releaseDate, String title, String description, String posterUrl, String director, String genre, String countryOfProduction) {
        super(pieceId, releaseDate);
        this.title = title;
        this.description = description;
        this.posterUrl = posterUrl;
        this.director = director;
        this.genre = genre;
        this.countryOfProduction = countryOfProduction;
    }


}
