package com.example.zf.mapers;

import com.example.zf.models.Movie;
import com.example.zf.models.dto.MovieInput;
import com.example.zf.models.dto.MovieOutput;

import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {

    public static List<MovieOutput> mapToMoviesOutput(List<Movie> movies){
        return movies.stream().map(movie -> mapToMovieOutput(movie)).collect(Collectors.toList());
    }

    public static MovieOutput mapToMovieOutput(Movie movie) {
        return MovieOutput.builder()
                .pieceId(movie.getPieceId())
                .releaseDate(movie.getReleaseDate())
                .title(movie.getTitle())
                .countryOfProduction(movie.getCountryOfProduction())
                .description(movie.getDescription())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .posterUrl(movie.getPosterUrl())
                .build();
    }

    public static Movie movieInputToMovie(MovieInput movieInput){
        return Movie.builder()
                .releaseDate(movieInput.getReleaseDate())
                .countryOfProduction(movieInput.getCountryOfProduction())
                .description(movieInput.getDescription())
                .director(movieInput.getDirector())
                .genre(movieInput.getGenre())
                .posterUrl(movieInput.getPosterUrl())
                .title(movieInput.getTitle())
                .build();
    }
}
