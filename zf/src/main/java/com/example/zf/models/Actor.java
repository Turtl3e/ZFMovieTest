package com.example.zf.models;

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
    public Set<Movie> movies;

    public Actor update(Actor updatedActor){
        this.setFirstName(updatedActor.getFirstName())
                .setSecondName(updatedActor.getSecondName())
                .setBorn(updatedActor.getBorn())
                .setDescription(updatedActor.getDescription())
                .setPlaceOfBirth(updatedActor.getPlaceOfBirth());
        return this;
    }
}
