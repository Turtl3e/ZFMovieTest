package com.example.zf.controlles;

import com.example.zf.mapers.MovieMapper;
import com.example.zf.models.Movie;
import com.example.zf.models.dto.MovieInput;
import com.example.zf.models.dto.MovieWithoutActorsDto;
import com.example.zf.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor //using instead of constructor injection
public class MovieController {

    private final MovieService movieService;

    @GetMapping("")
    public List<MovieWithoutActorsDto> getMovies() {

        return MovieMapper.mapToMoviesWithoutActorsDto(movieService.getMovies());
    }

    @PostMapping()
    public MovieWithoutActorsDto createMovie(@RequestBody MovieInput movieToCreate){
        return MovieMapper.mapToMovieWithoutActorsDto(movieService.createMovie(MovieMapper.movieInputToMovie(movieToCreate)));
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id)  {
        return movieService.getMovie(id);
    }

    @PutMapping("/{id}")
    public MovieWithoutActorsDto updateMovie(@PathVariable(value = "id") long movieToUpdateId, @RequestBody MovieInput updatedMovie){
        System.out.println(movieToUpdateId);
        return MovieMapper.mapToMovieWithoutActorsDto(movieService.updateMovie(movieToUpdateId,MovieMapper.movieInputToMovie(updatedMovie)));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable(value = "id") long movieToDeleteId){
        movieService.deleteMovie(movieToDeleteId);
    }
}
