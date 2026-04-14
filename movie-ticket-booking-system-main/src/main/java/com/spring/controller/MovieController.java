package com.spring.controller;

import com.spring.dto.MovieDto;
import com.spring.serviceImp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImp movieServiceImp;

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        MovieDto addedMovie = movieServiceImp.addMovie(movieDto);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
        
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDto>> getAllMovie(){
        List<MovieDto> movies = movieServiceImp.getAllMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovie(@RequestParam String title) {
        List<MovieDto> movies = movieServiceImp.getMovieByTitle(title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        MovieDto movieFound = movieServiceImp.getMovieById(id);
        return new ResponseEntity<>(movieFound, HttpStatus.OK);
    }

}
