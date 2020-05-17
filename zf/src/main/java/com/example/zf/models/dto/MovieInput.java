package com.example.zf.models.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class MovieInput  {
    private Date releaseDate;
    @NotNull
    private String title;
    private String description;
    private String posterUrl;
    private String director; //TODO: Should be a class
    private String genre; //TODO: Should be a list of strings or a class
    private String countryOfProduction;
}
