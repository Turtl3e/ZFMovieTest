package com.example.zf.services;

import com.example.zf.exceptions.MovieNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        //TODO: Should check if exist
        return actorRepository.save(actorToCreate);
    }

    @Transactional
    public Actor updateActor(long actorToUpdateId, Actor actorInputToActor) {
        Actor actorToUpdate=getActor(actorToUpdateId);
        actorToUpdate.update(actorInputToActor);
        //FIXME: save Could be removed when @Trainsactional?
        return actorRepository.save(actorToUpdate);
//        return actorToUpdate;
    }

    public void deleteActor(long actorToDeleteId) {
        Actor actorToDelete=getActor(actorToDeleteId);
        actorRepository.delete(actorToDelete);
    }

    public List<Actor> getActorsWithParams(String firstName, String secondName) {
        return actorRepository.findAllByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCase(firstName,secondName).orElse(Collections.emptyList());
    }

//    public List<Actor> getActorsWithParams(String firstOrSecondName) {
//        return actorRepository.findAllByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCase(firstOrSecondName).orElse(Collections.emptyList());
//    }
}
