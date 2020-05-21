package com.example.zf.services;

import com.example.zf.exceptions.MovieNotFoundException;
import com.example.zf.models.Actor;
import com.example.zf.models.Movie;

import com.example.zf.repositories.ActorRepository;
import com.example.zf.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        //TODO: Should check if exist
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

//    Could be
//    public Movie updateMovie(Movie updatedMovie) {
//       Movie movieToUpdate= movieRepository.findById(updatedMovie.getPieceId()).orElseThrow();
//        return movieRepository.save(updatedMovie);//should be save
//    }

    public void deleteMovie(long movieToDeleteId) {
        Movie movieToDelete=getMovie(movieToDeleteId);
        movieRepository.delete(movieToDelete);
    }

    public Actor addActorToMovie(long movieId, Actor actorInputToActor) {
        Movie movie= getMovie(movieId);
        Actor actorToAdd=actorRepository.findByFirstNameAndSecondName(actorInputToActor.getFirstName(),actorInputToActor.getSecondName()).
                orElse(actorRepository.save(actorInputToActor));
        movie.getActors().add(actorToAdd);
        movieRepository.save(movie);
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
