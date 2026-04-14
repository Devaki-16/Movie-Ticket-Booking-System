package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.ScreenDto;
import com.spring.serviceImp.ScreenServiceImp;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    ScreenServiceImp screenServiceImp;

    @PostMapping("/addScreen")
    public ResponseEntity<ScreenDto> addScreen(@RequestBody ScreenDto screenDto) {
        ScreenDto screen = screenServiceImp.addScreen(screenDto);
        return new ResponseEntity<>(screen, HttpStatus.CREATED);
    }

    @GetMapping("/getAllScreens")
    public List<ScreenDto> getAllScreen(){
        return screenServiceImp.getAllScreen();
    }

    @DeleteMapping("/DeleteById/{screenId}")
    public ResponseEntity<String> deleteScreen(
            @PathVariable Long screenId) {

        screenServiceImp.deleteScreen(screenId);
        return ResponseEntity.ok("Screen deleted successfully");
    }

}