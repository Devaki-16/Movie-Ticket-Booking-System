package com.spring.service;

import java.util.List;

import com.spring.dto.ScreenDto;

public interface ScreenService {

    ScreenDto addScreen(ScreenDto screenDto);
    List<ScreenDto> getAllScreen();
    public ScreenDto deleteScreen(Long screenId);
}