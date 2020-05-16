package com.example.zf.models;

import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long pieceId;
    private Date releaseDate;
}
