package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.ShowDto;
import com.spring.entity.Show;
import com.spring.serviceImp.ShowServiceImp;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowServiceImp showServiceImp;

    @PostMapping("/addShow")
    public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDto) {
        ShowDto show = showServiceImp.addShow(showDto);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }

    @GetMapping("/getAllShows")
    public ResponseEntity<List<ShowDto>> getAllShow(){
        List<ShowDto> shows = showServiceImp.getAllShow();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/searchShowByMovieTitle")
    public ResponseEntity<List<ShowDto>> searchShow(@RequestParam String movieTitle) {
        List<ShowDto> shows = showServiceImp.getShowByMovieTitle(movieTitle);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @DeleteMapping("/deleteShow/{showId}")
    public ResponseEntity<ShowDto> deleteShow(@PathVariable Long showId) {
        ShowDto show = showServiceImp.deleteShow(showId);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping("/getShowByCityAndTitle")
    public ResponseEntity<List<ShowDto>> getShowByCityAndMovie(@RequestParam String city, @RequestParam String title) {
      
        List<ShowDto> shows = showServiceImp.getShowByCityAndMovieTitle(city, title);
        return new ResponseEntity<>(shows, HttpStatus.OK);

    }

    @GetMapping("/getShowsByCandT")
    public ResponseEntity<List<ShowDto>> getShowsByCandT(@RequestParam String city, @RequestParam String title) {

        List<ShowDto> shows = showServiceImp.getShowsByCandT(city, title);
        return new ResponseEntity<>(shows, HttpStatus.OK);

    }

}