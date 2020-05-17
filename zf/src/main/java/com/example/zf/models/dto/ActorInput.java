package com.example.zf.models.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ActorInput {
    private String firstName;
    private String secondName;
    private Date born;
    private String placeOfBirth;
    private String description;
}
