package com.example.zf.services;

import com.example.zf.exceptions.ActorAlreadyExistException;
import com.example.zf.exceptions.MovieAlreadyExistException;
import com.example.zf.exceptions.MovieNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.models.Movie;

import com.example.zf.repositories.ActorRepository;
import com.example.zf.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(long id){
        return movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException(id));
    }

    public Movie createMovie(Movie movieToCreate){
        if(movieRepository.existsByTitleIgnoreCase(movieToCreate.getTitle()))
            throw new MovieAlreadyExistException(movieToCreate.getTitle());
        return movieRepository.save(movieToCreate);
    }

    @Transactional
    public Movie updateMovie(long movieToUpdateId,Movie updatedMovie) {
        Movie movieToUpdate=getMovie(movieToUpdateId);
        movieToUpdate.updateMovie(updatedMovie);
        //FIXME: save Could be removed when @Trainsactional?
        return movieRepository.save(movieToUpdate);
//        return movieToUpdate;
    }

    public void deleteMovie(long movieToDeleteId) {
        Movie movieToDelete=getMovie(movieToDeleteId);
        movieRepository.delete(movieToDelete);
    }

    @Transactional
    public Actor addActorToMovie(long movieId, Actor actorInputToActor) {
        Movie movie= getMovie(movieId);
        Actor actorToAdd= actorRepository.findByFirstNameIgnoreCaseAndSecondNameIgnoreCase(actorInputToActor.getFirstName(),actorInputToActor.getSecondName())
                .orElseGet(()-> actorRepository.save(actorInputToActor));

        //Exception handle
        if(movie.hasActor(actorToAdd))
            throw new ActorAlreadyExistException(actorToAdd.getFirstName(),actorToAdd.getSecondName(),movie.getTitle());

        movie.getActors().add(actorToAdd);
        return actorToAdd;
    }

    public void removeActorFromMovie(long movieId, long actorId){
        Movie movie=getMovie(movieId);
        //FIXME:
        Actor actorToRemove=actorRepository.findById(actorId).orElseThrow(()-> new MovieNotFoundException(actorId));
        movie.removeActor(actorToRemove);
        movieRepository.save(movie);
    }
}
