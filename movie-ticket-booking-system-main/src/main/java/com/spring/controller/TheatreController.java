package com.spring.controller;

import com.spring.dto.ScreenDto;
import com.spring.dto.TheatreDto;
import com.spring.serviceImp.TheatreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreServiceImp theatreServiceImp;

    @PostMapping("/addTheatre")
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto) {
        TheatreDto theatres = theatreServiceImp.addTheatre(theatreDto);
        return new ResponseEntity<>(theatres, HttpStatus.CREATED);
    }

    @GetMapping("/getTheatreById/{id}")
    public ResponseEntity<TheatreDto> getTheatreById(@PathVariable Long id) {
        TheatreDto theatreDto = theatreServiceImp.getTheatreById(id);
        return new ResponseEntity<>(theatreDto, HttpStatus.OK);
    }

    @GetMapping("/getAllTheatre")
    public ResponseEntity<List<TheatreDto>> getAllTheatres() {
        List<TheatreDto> theatres  = theatreServiceImp.getAllTheatres();
        return new ResponseEntity(theatres, HttpStatus.OK);
    }

    @PutMapping("/updateTheatre/{id}")
    public ResponseEntity<TheatreDto> updateTheatre(@PathVariable Long id, @RequestBody TheatreDto theatreDto) {
        TheatreDto thatre = theatreServiceImp.updateTheatre(id, theatreDto);
        return new ResponseEntity<>(thatre, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTheatre/{id}")
    public ResponseEntity<TheatreDto> deleteTheatre(@PathVariable Long id) {
        return new ResponseEntity<>(theatreServiceImp.deleteTheatre(id), HttpStatus.OK);
    }

    @GetMapping("/getScreensByTheatreId/{theatreId}")
    public ResponseEntity<List<ScreenDto>> getScreensByTheatre(@PathVariable Long theatreId) {
        List<ScreenDto> screens = theatreServiceImp.getScreensByTheatreId(theatreId);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/getTheatreByCity/{location}")
    public ResponseEntity<List<TheatreDto>> getTheatresByLocation(@PathVariable String location) {
        List<TheatreDto> theatres = theatreServiceImp.getTheatresByCity(location);
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }
}
