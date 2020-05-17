package com.example.zf.services;

import com.example.zf.exceptions.MovieNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public List<Actor> getActors(){
        return actorRepository.findAll();
    }

    public Actor getActor(long id){
        return actorRepository.findById(id).orElseThrow(()->new MovieNotFoundException(id));
    }

    public Actor createActor(Actor actorToCreate){
        return actorRepository.save(actorToCreate);
    }

    public Actor updateActor(long actorToUpdateId, Actor actorInputToActor) {
        Actor actorToUpdate=getActor(actorToUpdateId);
        return actorToUpdate.update(actorInputToActor);
    }

    public void deleteActor(long actorToDeleteId) {
        Actor actorToDelete=getActor(actorToDeleteId);
        actorRepository.delete(actorToDelete);
    }
}
