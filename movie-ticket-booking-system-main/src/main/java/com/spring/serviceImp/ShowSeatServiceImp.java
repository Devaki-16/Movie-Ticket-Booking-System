package com.spring.serviceImp;

import com.spring.dto.ShowSeatDto;
import com.spring.entity.Seat;
import com.spring.entity.Show;
import com.spring.entity.ShowSeat;
import com.spring.enums.SeatStatus;
import com.spring.mapper.ShowSeatMapper;
import com.spring.repositary.ShowRepositary;
import com.spring.repositary.ShowSeatRepositary;
import com.spring.service.ShowSeatService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowSeatServiceImp implements ShowSeatService {

    @Autowired
    ShowRepositary showRepositary;

    @Autowired
    ShowSeatRepositary showSeatRepositary;

    @Override
    public void createShowSeats(Long showId) {
        List<Seat> seats;
        Show show;
        try{
            show = showRepositary.findById(showId)
                    .orElseThrow(() -> new RuntimeException("Show not found"));
                   
           seats = show.getScreen().getSeats();
        }catch(Exception e){
          
            throw e; // rethrow the exception after logging
        }


        // for (Seat seat : seats) {
        //     ShowSeat showSeat = new ShowSeat();
        //     showSeat.setShow(show);
        //     showSeat.setSeat(seat);
        //     showSeat.setStatus(SeatStatus.AVAILABLE);
        //     showSeatRepositary.save(showSeat);
        // }

        List<ShowSeat> showSeats = seats.stream().map(seat -> {
            ShowSeat ss = new ShowSeat();
  
            ss.setShow(show);          // managed
            ss.setSeat(seat);          // managed
            ss.setStatus(SeatStatus.AVAILABLE);
            return ss;
        }).toList();

        showSeatRepositary.saveAll(showSeats);
        
    }

    @Override
    public List<ShowSeatDto> getSeatsByShow(Long showId) {
        List<ShowSeat> showSeats = showSeatRepositary.findByShow_ShowId(showId);
        return showSeats.stream().map(ShowSeatMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ShowSeatDto> getAvailableSeats(Long showId) {
       List<ShowSeat> availableShowSeats = showSeatRepositary.findByShow_ShowIdAndStatus(
                showId, SeatStatus.AVAILABLE
        );
        return availableShowSeats.stream()
                .map(ShowSeatMapper::toDto)
                .collect(Collectors.toList());
    }

    //  Lock seats (before payment)
    @Override
    public void  lockSeats(Long showId, List<Long> seatIds) {
        for (Long seatId : seatIds) {

            ShowSeat showSeat = showSeatRepositary
                    .findByShow_ShowIdAndSeat_SeatId(showId, seatId)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

       
            if (showSeat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat already booked or locked");
            }

            showSeat.setStatus(SeatStatus.LOCKED);
            showSeatRepositary.save(showSeat);
        }

        
    }

    //  Confirm seats (after payment success)
    @Override
    public void confirmSeats(Long showId, List<Long> seatIds) {
        for (Long seatId : seatIds) {

            ShowSeat showSeat = showSeatRepositary
                    .findByShow_ShowIdAndSeat_SeatId(showId, seatId)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));
        
            if (showSeat.getStatus() != SeatStatus.LOCKED) {
                throw new RuntimeException("Seat not locked");
            }

            showSeat.setStatus(SeatStatus.BOOKED);

            showSeatRepositary.save(showSeat);
        }
    }

    // Release seats (payment failed / timeout)
    @Override
    public void releaseSeats(Long showId, List<Long> seatIds) {
        for (Long seatId : seatIds) {

            ShowSeat showSeat = showSeatRepositary
                    .findByShow_ShowIdAndSeat_SeatId(showId, seatId)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            if (showSeat.getStatus() == SeatStatus.LOCKED) {
                showSeat.setStatus(SeatStatus.AVAILABLE);
            }

            showSeatRepositary.save(showSeat);
        }
    }
}
