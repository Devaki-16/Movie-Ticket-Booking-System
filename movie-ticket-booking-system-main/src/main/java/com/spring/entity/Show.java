package com.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "shows",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"screen_id", "showTime"})
        })
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    public Long getShowId() {
		return showId;
	}

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(Long showId, Movie movie, Screen screen, LocalDateTime showTime) {
		super();
		this.showId = showId;
		this.movie = movie;
		this.screen = screen;
		this.showTime = showTime;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	@ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(nullable = false)
    private LocalDateTime showTime;

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", screen=" + screen +
                ", showTime=" + showTime +
                '}';
    }
}
