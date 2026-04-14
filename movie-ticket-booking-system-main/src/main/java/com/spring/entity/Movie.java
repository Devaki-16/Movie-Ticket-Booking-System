package com.spring.entity;

import jakarta.persistence.*;


@Entity
@Table(name="movies",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title", "language", "releaseYear"})
        })
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    public Long getMovieId() {
		return movieId;
	}


	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(Long movieId, String title, String language, Integer releaseYear, String genre, Integer duration) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.language = language;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.duration = duration;
	}


	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	private String language;
    private Integer releaseYear;
    private String genre;

    private Integer duration;


    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
}
