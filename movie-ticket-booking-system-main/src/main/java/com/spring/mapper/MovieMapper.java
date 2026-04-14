package com.spring.mapper;

import com.spring.dto.MovieDto;
import com.spring.entity.Movie;

public class MovieMapper {
    
    public static MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setGenre(movie.getGenre());
        movieDto.setDuration(movie.getDuration());
        return movieDto;
    }
    public static Movie toEntity(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setGenre(movieDto.getGenre());
        movie.setDuration(movieDto.getDuration());
        return movie;
    }
}
