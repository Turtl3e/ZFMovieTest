package com.example.zf.models.dto;

import com.example.zf.models.Actor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
public class MovieDto {

    private Long pieceId;
    private LocalDate releaseDate;
    private String title;
    private String description;
    private String posterUrl;
    private String director; //TODO: Should be a class
    private String genre; //TODO: Should be a list of strings or a class
    private String countryOfProduction;
    public List<ActorWithoutMoviesDto> actors;
}
