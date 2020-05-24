package com.example.zf.models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class ActorInput {
    private String firstName;
    private String secondName;
    private LocalDate born;
    private String placeOfBirth;
    private String description;
    private String posterUrl;
}
