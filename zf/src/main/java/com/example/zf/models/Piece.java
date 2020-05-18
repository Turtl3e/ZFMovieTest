package com.example.zf.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="@pieceId")
public abstract class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long pieceId;
    private Date releaseDate;
}
