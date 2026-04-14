package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.SeatDto;
import com.spring.serviceImp.SeatServiceImp;

@RestController
@RequestMapping("/seat")
public class SeatController {


    @Autowired
    SeatServiceImp seatServiceImp;

    @PostMapping("/addSeatByScreenId/{screenId}")
    public ResponseEntity<SeatDto> addSeat(@PathVariable Long screenId,
                        @RequestBody SeatDto seatDto) {
        SeatDto seat = seatServiceImp.addSeat(seatDto,screenId);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @GetMapping("getAllSeats/{screenId}")
    public ResponseEntity<List<SeatDto>> getAllSeatsByScreenId(@PathVariable Long screenId){
        List<SeatDto> seats = seatServiceImp.getAllSeatsByScreenId(screenId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }


    @PutMapping("/updateSeat/{id}")
    public ResponseEntity<SeatDto> updateSeat(@PathVariable Long id,@RequestBody SeatDto seatDto) {
        SeatDto seat = seatServiceImp.updateSeat(id,seatDto);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PostMapping("/addBulk/{screenId}")
    public ResponseEntity<List<SeatDto>> addSeatsInBulk(@PathVariable Long screenId,
                                     @RequestBody List<SeatDto> seats) {
        List<SeatDto> addedSeats = seatServiceImp.addSeatsInBulk(screenId, seats);
        return new ResponseEntity<>(addedSeats, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{screenId}/{seatId}")
    public ResponseEntity<SeatDto> deleteSeat(@PathVariable Long screenId,
                             @PathVariable Long seatId) {
        SeatDto seat = seatServiceImp.deleteSeat(screenId, seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);                        
    }


}