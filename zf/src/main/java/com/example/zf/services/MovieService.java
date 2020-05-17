package com.example.zf.services;

import com.example.zf.exceptions.MovieNotFoundException;
import com.example.zf.models.Movie;

import com.example.zf.models.dto.MovieInput;
import com.example.zf.models.dto.MovieOutput;
import com.example.zf.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(long id){
        return movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException(id));
    }

    public Movie createMovie(Movie movieToCreate){
        return movieRepository.save(movieToCreate);
    }

    public Movie updateMovie(long movieToUpdateId,Movie updatedMovie) {
        Movie movieToUpdate=getMovie(movieToUpdateId);
        return movieToUpdate.updateMovie(updatedMovie);
    }

    public void deleteMovie(long movieToDeleteId) {
        Movie movieToDelete=getMovie(movieToDeleteId);
        movieRepository.delete(movieToDelete);
    }
}
