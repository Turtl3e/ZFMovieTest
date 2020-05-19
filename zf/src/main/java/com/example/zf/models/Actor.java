package com.example.zf.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="@movies")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long actorId;
    private String firstName;
    private String secondName;
    private Date born;
    private String placeOfBirth;
    private String description;

    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    public List<Movie> movies;

    public void update(Actor updatedActor){
        this.setFirstName(updatedActor.getFirstName())
                .setSecondName(updatedActor.getSecondName())
                .setBorn(updatedActor.getBorn())
                .setDescription(updatedActor.getDescription())
                .setPlaceOfBirth(updatedActor.getPlaceOfBirth());
    }
}
