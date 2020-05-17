package com.example.zf.models.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ActorWithoutMoviesDto {
    private Long actorId;
    private String firstName;
    private String secondName;
    private Date born;
    private String placeOfBirth;
    private String description;
}
