package com.spring.controller;

import com.spring.dto.ShowSeatDto;
import com.spring.serviceImp.ShowSeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show-seats")
public class ShowSeatController {

    @Autowired
    ShowSeatServiceImp showSeatServiceImp;
    // Seats of a show
    @GetMapping("GetAllSeatByShowId/{showId}")
    public ResponseEntity<List<ShowSeatDto>> getSeats(@PathVariable Long showId) {
        return new ResponseEntity<>(showSeatServiceImp.getSeatsByShow(showId),HttpStatus.OK);
    }

    // Available seats
    @GetMapping("availableSeatsByShowId/{showId}")
    public ResponseEntity<List<ShowSeatDto>> getAvailableSeats(@PathVariable Long showId) {
        return new ResponseEntity<>(showSeatServiceImp.getAvailableSeats(showId),HttpStatus.OK);
    }

    // Lock seats
    @PostMapping("lockSeatByShowId/{showId}")
    public void lockSeats(
            @PathVariable Long showId,
            @RequestBody List<Long> seatIds) {
        showSeatServiceImp.lockSeats(showId, seatIds);
    }

    // Confirm seats
    @PostMapping("confrimSeatByShowId/{showId}")
    public void confirmSeats(
            @PathVariable Long showId,
            @RequestBody List<Long> seatIds) {
        showSeatServiceImp.confirmSeats(showId, seatIds);
    }

    // Release seats
    @PostMapping("releaseSeatByShowId/{showId}")
    public void releaseSeats(
            @PathVariable Long showId,
            @RequestBody List<Long> seatIds) {
        showSeatServiceImp.releaseSeats(showId, seatIds);
    }
}
