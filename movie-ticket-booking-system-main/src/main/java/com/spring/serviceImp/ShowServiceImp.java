package com.spring.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.entity.Screen;
import com.spring.repositary.ScreenRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.ShowDto;
import com.spring.entity.Movie;
import com.spring.entity.Show;
import com.spring.mapper.ShowMapper;
import com.spring.repositary.MovieRepositary;
import com.spring.repositary.ShowRepositary;
import com.spring.service.ShowService;

import lombok.extern.slf4j.Slf4j;

@Service
public class ShowServiceImp implements ShowService {


    @Autowired
    ShowRepositary showRepositary;

    @Autowired
    MovieRepositary movieRepositary;

    @Autowired
    ScreenRepositary screenRepositary;

    @Autowired
    ShowSeatServiceImp showSeatServiceImp;

    @Override
    public ShowDto addShow(ShowDto showDto) {
        Movie movie = movieRepositary.findById(showDto.getMovie().getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Screen screen = screenRepositary.findById(showDto.getScreen().getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        Show newShow=new Show();
        newShow.setMovie(movie);
        newShow.setScreen(screen);
        newShow.setShowTime(showDto.getShowTime());

        Show savedShow = showRepositary.save(newShow);
        try{
            showSeatServiceImp.createShowSeats(savedShow.getShowId());
        }catch(Exception e){
            
            throw e; // rethrow the exception after logging
        }

        return ShowMapper.toDto(savedShow);
    }
    @Override
    public List<ShowDto> getAllShow() {
        List<Show> shows = showRepositary.findAll();
        return shows.stream().map(ShowMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ShowDto> getShowByMovieTitle(String movieTitle) {
       /* Movie movie = movieRepositary.findByTitle(movieTitle);
        log.info("Movie found: " + movie);
        Long movieId=movie.getMovieId();
        List<Show> showList = showRepositary.findByMovie_MovieId(movieId);
        log.info("Shows found: " + showList);
        return showList;*/

        List<Show> shows = showRepositary.findByMovie_TitleContainingIgnoreCase(movieTitle);
        return shows.stream().map(ShowMapper::toDto).collect(Collectors.toList());

    }
    @Override
    public ShowDto deleteShow(Long showId) {
        /*log.info("In the deleteShow method " + showId );
        Show show = showRepositary.findById(showId).orElse(null);
        if(show == null) {
            log.info("Show with id " + showId + " not found.");
            return null;
        }else {
            log.info("Deleting show: " + show);
            showRepositary.delete(show);
            return show;
        }*/

        Show show = showRepositary.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show Not Found: " + showId));
        showRepositary.delete(show);
        return ShowMapper.toDto(show);
    }
    @Override
    public List<ShowDto> getShowByCityAndMovieTitle(String city, String title) {
    
        List<Show> shows = showRepositary.findByScreen_Theatre_CityAndMovie_Title(city, title);
        return shows.stream().map(ShowMapper::toDto).collect(Collectors.toList());
        
    }

    @Override
    public List<ShowDto> getShowsByCandT(String city, String movieTitle) {
      
        List<Show> shows =  showRepositary.findByMovie_TitleAndScreen_Theatre_City(city, movieTitle);
        return shows.stream().map(ShowMapper::toDto).collect(Collectors.toList());
    }




}