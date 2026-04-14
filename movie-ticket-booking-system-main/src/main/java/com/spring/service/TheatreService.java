package com.spring.service;

import com.spring.dto.ScreenDto;
import com.spring.dto.TheatreDto;

import java.util.List;

public interface TheatreService {
    TheatreDto addTheatre(TheatreDto theatreDto);
    TheatreDto getTheatreById(Long theatreId);
    List<TheatreDto> getAllTheatres();
    TheatreDto updateTheatre(Long theatreId, TheatreDto theatreDto);
    TheatreDto deleteTheatre(Long theatreId);
    List<TheatreDto> getTheatresByCity(String city);
    List<ScreenDto> getScreensByTheatreId(Long theatreId);
}
