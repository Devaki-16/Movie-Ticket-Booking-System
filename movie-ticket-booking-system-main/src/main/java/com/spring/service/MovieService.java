package com.spring.service;

import com.spring.dto.MovieDto;

import java.util.List;

public interface MovieService {
    public MovieDto addMovie(MovieDto movieDto);
    public List<MovieDto> getAllMovie();
    List<MovieDto> getMovieByTitle(String title);
    public MovieDto getMovieById(Long movieId);
}
