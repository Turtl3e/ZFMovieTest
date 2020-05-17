package com.example.zf.controlles;

import com.example.zf.mapers.MovieMapper;
import com.example.zf.models.Movie;
import com.example.zf.models.dto.MovieInput;
import com.example.zf.models.dto.MovieOutput;
import com.example.zf.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor //using instead of constructor injection
public class MovieController {

    private final MovieService movieService;

    @GetMapping("")
    public List<MovieOutput> getMovies() {

        return MovieMapper.mapToMoviesOutput(movieService.getMovies());
    }

    @PostMapping()
    public MovieOutput createMovie(@RequestBody MovieInput movieToCreate){
        return MovieMapper.mapToMovieOutput(movieService.createMovie(MovieMapper.movieInputToMovie(movieToCreate)));
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id)  {
        return movieService.getMovie(id);
    }

    @PutMapping("/{id}")
    public MovieOutput updateMovie(@PathVariable(value = "id") long movieToUpdateId, @RequestBody MovieInput updatedMovie){
        System.out.println(movieToUpdateId);
        return MovieMapper.mapToMovieOutput(movieService.updateMovie(movieToUpdateId,MovieMapper.movieInputToMovie(updatedMovie)));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable(value = "id") long movieToDeleteId){
        movieService.deleteMovie(movieToDeleteId);
    }
}
