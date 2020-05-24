package com.example.zf.models.dto;

import com.example.zf.models.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class ActorDto {
    private Long actorId;
    private String firstName;
    private String secondName;
    private LocalDate born;
    private String placeOfBirth;
    private String description;
    private String posterUrl;
    public List<MovieWithoutActorsDto> movies;
}
