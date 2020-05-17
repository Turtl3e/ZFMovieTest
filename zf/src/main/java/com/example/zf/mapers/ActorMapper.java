package com.example.zf.mapers;

import com.example.zf.models.Actor;
import com.example.zf.models.Movie;
import com.example.zf.models.dto.ActorInput;
import com.example.zf.models.dto.ActorWithoutMoviesDto;
import com.example.zf.models.dto.MovieWithoutActorsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {

    public static List<ActorWithoutMoviesDto> mapToActorsWithoutMoviesDto(List<Actor> actors){
        return actors.stream().map(actor -> mapToActorWithoutMoviesDto(actor)).collect(Collectors.toList());
    }

    public static ActorWithoutMoviesDto mapToActorWithoutMoviesDto(Actor actor) {
        return ActorWithoutMoviesDto.builder()
                .actorId(actor.getActorId())
                .born(actor.getBorn())
                .description(actor.getDescription())
                .firstName(actor.getFirstName())
                .secondName(actor.getSecondName())
                .placeOfBirth(actor.getPlaceOfBirth())
                .build();
    }

    public static Actor actorInputToActor(ActorInput actorInput){
        return Actor.builder()
                .firstName(actorInput.getFirstName())
                .secondName(actorInput.getSecondName())
                .born(actorInput.getBorn())
                .description(actorInput.getDescription())
                .placeOfBirth(actorInput.getPlaceOfBirth())
                .build();
    }
}
