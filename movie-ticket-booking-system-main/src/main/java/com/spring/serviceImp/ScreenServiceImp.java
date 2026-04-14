package com.spring.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.entity.Theatre;
import com.spring.mapper.ScreenMapper;
import com.spring.mapper.TheatreMapper;
import com.spring.repositary.TheatreRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.ScreenDto;
import com.spring.dto.TheatreDto;
import com.spring.entity.Screen;
import com.spring.repositary.ScreenRepositary;
import com.spring.service.ScreenService;

import lombok.extern.slf4j.Slf4j;

@Service
public class ScreenServiceImp implements ScreenService{

    @Autowired
    ScreenRepositary screenRepositary;

    @Autowired
    TheatreRepositary theatreRepositary;

    @Override
    public ScreenDto addScreen(ScreenDto screenDto) {
        Long theatreId = screenDto.getTheatreDto().getTheatreId();
        
        Theatre theatre = theatreRepositary.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        TheatreDto theatreDto = TheatreMapper.toDto(theatre);
        screenDto.setTheatreDto(theatreDto); // full entity attached

        Screen screen = ScreenMapper.toEntity(screenDto);
        screenRepositary.save(screen);
        return ScreenMapper.toDto(screen);
    }
    @Override
    public List<ScreenDto> getAllScreen() {
        List<Screen> screens = screenRepositary.findAll();
        return screens.stream().map(ScreenMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ScreenDto deleteScreen(Long screenId) {

        Screen screen = screenRepositary.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));
        screenRepositary.delete(screen);
        return ScreenMapper.toDto(screen);
    }
}