package com.spring.service;

import java.util.List;

import com.spring.dto.ShowDto;

public interface ShowService {

    public ShowDto addShow(ShowDto showDto);
    public List<ShowDto> getAllShow();
    public List<ShowDto> getShowByMovieTitle(String movieTitle);
    public ShowDto deleteShow(Long showId);
    public List<ShowDto> getShowByCityAndMovieTitle(String city, String movieTitle);
    List<ShowDto> getShowsByCandT(String city, String movieTitle);
}