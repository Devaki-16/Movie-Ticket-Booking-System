package com.spring.serviceImp;

import com.spring.dto.MovieDto;
import com.spring.entity.Movie;
import com.spring.exception.MovieAlreadyPresent;
import com.spring.exception.MovieNotFound;
import com.spring.mapper.MovieMapper;
import com.spring.repositary.MovieRepositary;
import com.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    MovieRepositary movieRepositary;

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Optional<Movie> existingMovie = movieRepositary.findByTitleAndLanguageAndReleaseYear(
                movieDto.getTitle(), movieDto.getLanguage(), movieDto.getReleaseYear()
        );
        Movie movie = MovieMapper.toEntity(movieDto);
        if (existingMovie.isPresent()) {
            throw new MovieAlreadyPresent("Movie already exists with same title, language, and release year");
        }else {
            movieRepositary.save(movie);
            return MovieMapper.toDto(movie);
        }
    }

    @Override
    public List<MovieDto> getAllMovie() {
        List<Movie> movies = movieRepositary.findAll();
        return movies.stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public List<MovieDto> getMovieByTitle(String title) {
        List<Movie> existingMovie=movieRepositary.findByTitleContainingIgnoreCase(title);
        if(existingMovie.isEmpty()){
            throw new MovieNotFound(title);
        }else{
            return existingMovie.stream().map(MovieMapper::toDto).collect(Collectors.toList());
        }
    }

    @Override
    public MovieDto getMovieById(Long movieId) {
        Movie movie = movieRepositary.findById(movieId)
                .orElseThrow(() -> new MovieNotFound(movieId.toString()));
        return MovieMapper.toDto(movie);
    }
}
