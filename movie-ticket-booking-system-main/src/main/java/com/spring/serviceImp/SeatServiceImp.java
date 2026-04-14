package com.spring.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.SeatDto;
import com.spring.entity.Screen;
import com.spring.entity.Seat;
import com.spring.mapper.ScreenMapper;
import com.spring.mapper.SeatMapper;
import com.spring.repositary.ScreenRepositary;
import com.spring.repositary.SeatRepositary;
import com.spring.service.SeatService;

import lombok.extern.slf4j.Slf4j;

@Service
public class SeatServiceImp  implements SeatService{


    @Autowired
    SeatRepositary seatRepositary;

    @Autowired
    ScreenRepositary screenRepositary;

    @Override
    public SeatDto addSeat(SeatDto seatDto,Long screenId) {

        Screen screen = screenRepositary.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        if (seatRepositary.existsBySeatNumberAndScreen_ScreenId(
                seatDto.getSeatNumber(), screenId)) {
            throw new RuntimeException("Seat already exists in this screen");
        }

        /*newSeatSeat newSeat = new Seat();
        newSeat.setSeatNumber(seat.getSeatNumber());
        newSeat.setScreen(screen);
        newSeat.setSeatType(seat.getSeatType());
        newSeat.setPrice(seat.getPrice());


        return seatRepositary.save(newSeat);*/
        // seatDto.setScreen(ScreenMapper.toDto(screen));
        // seatRepositary.save(SeatMapper.toEntity(seatDto));
        // return seatDto;

        Seat seat = SeatMapper.toEntity(seatDto);  // convert DTO to Seat
        seat.setScreen(screen);  // attach the managed Screen entity

        Seat savedSeat = seatRepositary.save(seat);  // save Seat
        return SeatMapper.toDto(savedSeat);
    }

    @Override
    public List<SeatDto> getAllSeatsByScreenId(Long screenId) {
        
        List<Seat> seats = seatRepositary.findByScreen_ScreenId(screenId);
      
        return seats.stream().map(SeatMapper::toDto).collect(Collectors.toList());

    }


    @Override
    public SeatDto updateSeat(Long id, SeatDto seatDto) {
        Seat existingSeat = seatRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        existingSeat.setSeatNumber(seatDto.getSeatNumber());
        existingSeat.setSeatType(seatDto.getSeatType());
        existingSeat.setPrice(seatDto.getPrice());
        existingSeat.setScreen(ScreenMapper.toEntity(seatDto.getScreen()));
        seatRepositary.save(existingSeat);
        return  SeatMapper.toDto(existingSeat);
    }

    @Override
    public List<SeatDto> addSeatsInBulk(Long screenId, List<SeatDto> seats) {
        // Screen screen = screenRepositary.findById(screenId)
        //         .orElseThrow(() -> new RuntimeException("Screen not found"));
        
        // List<Seat> seatEntities = new ArrayList<>();

        // for (SeatDto seatDto : seats) {
        //     if (seatRepositary.existsBySeatNumberAndScreen_ScreenId(
        //             seatDto.getSeatNumber(), screenId)) {
        //         throw new RuntimeException("Duplicate seat: " + seatDto.getSeatNumber());
        //     }
        //      Seat seat = SeatMapper.toEntity(seatDto);  // convert DTO to entity
        //      seat.setScreen(screen);                     // attach managed Screen entity
        //      seatEntities.add(seat);
        // }
        // List<Seat> savedSeats = seatRepositary.saveAll(seatEntities);

        // List<Seat> seatEntities = seats.stream()
        //         .map(SeatMapper::toEntity)
        //         .collect(Collectors.toList());
        // seatRepositary.saveAll(seatEntities);
        // return seats;

                Screen screen = screenRepositary.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        List<Seat> seatEntities = new ArrayList<>();

        for (SeatDto seatDto : seats) {
            if (seatRepositary.existsBySeatNumberAndScreen_ScreenId(
                    seatDto.getSeatNumber(), screenId)) {
                throw new RuntimeException("Duplicate seat: " + seatDto.getSeatNumber());
            }

            Seat seat = SeatMapper.toEntity(seatDto);  // convert DTO to entity
            seat.setScreen(screen);                     // attach managed Screen entity
            seatEntities.add(seat);
        }

        List<Seat> savedSeats = seatRepositary.saveAll(seatEntities);

        // convert back to DTOs for response
        return savedSeats.stream()
                        .map(SeatMapper::toDto)
                        .collect(Collectors.toList());

    }

    @Override
    public SeatDto deleteSeat(Long screenId, Long seatId) {
        Seat seat = seatRepositary.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (!seat.getScreen().getScreenId().equals(screenId)) {
            throw new RuntimeException("Seat does not belong to this screen");
        }

        seatRepositary.delete(seat);
        return  SeatMapper.toDto(seat);
    }


}