package com.spring.serviceImp;

import com.spring.dto.ScreenDto;
import com.spring.dto.TheatreDto;
import com.spring.entity.Screen;
import com.spring.entity.Theatre;
import com.spring.mapper.ScreenMapper;
import com.spring.mapper.TheatreMapper;
import com.spring.repositary.TheatreRepositary;
import com.spring.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheatreServiceImp implements TheatreService {

    @Autowired
    TheatreRepositary theatreRepositary;

    @Override
    public TheatreDto addTheatre(TheatreDto theatreDto) {
        if (theatreRepositary.existsByName(theatreDto.getName())) {
            throw new RuntimeException("Theatre with name '" + theatreDto.getName() + "' already exists");
        }
        Theatre theatre = TheatreMapper.toEntity(theatreDto);
        theatreRepositary.save(theatre);
        return TheatreMapper.toDto(theatre);
    }

    @Override
    public TheatreDto getTheatreById(Long theatreId) {
        Theatre theatre = theatreRepositary.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreId));
        return TheatreMapper.toDto(theatre);
    }

    @Override
    public List<TheatreDto> getAllTheatres() {
        List<Theatre> theatres = theatreRepositary.findAll();
        return theatres.stream()
                .map(TheatreMapper::toDto)
                .toList();
    }

    @Override
    public TheatreDto updateTheatre(Long theatreId, TheatreDto theatreDto) {
        Theatre existing = theatreRepositary.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreId));
        existing.setName(theatreDto.getName());
        existing.setCity(theatreDto.getCity());
        theatreRepositary.save(existing);
        return TheatreMapper.toDto(existing);
    }

    @Override
    public TheatreDto deleteTheatre(Long theatreId) {
        Theatre theatre = theatreRepositary.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreId));
        theatreRepositary.delete(theatre);
        return TheatreMapper.toDto(theatre);
    }

    @Override
    public List<TheatreDto> getTheatresByCity(String city) { 
        List<Theatre> theatres =  theatreRepositary.findAll().stream()
                .filter(t -> t.getCity() != null && t.getCity().equalsIgnoreCase(city))
                .toList();

                return theatres.stream()
                .map(TheatreMapper::toDto)
                .toList();
                
    }

    @Override
    public List<ScreenDto> getScreensByTheatreId(Long theatreId) {
        Theatre theatre = theatreRepositary.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreId));
        List<Screen> screens = theatre.getScreens();
        return screens.stream()
                .map(ScreenMapper::toDto)
                .toList();
    }


}
