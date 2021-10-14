package com.vishwa.mbs.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * I want the name of the table should be Cinema
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId ;

    @Column(length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(name = "movie_desc", length = 500, nullable = false)
    private String movieDescription;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duration;

    @Column(length = 500, nullable = false)
    private String coverPhotoUrl;

    @Column(length = 500, nullable = false)
    private String trailerUrl;


    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName='" + movieName + '\'' + ", movieDescription='"
                + movieDescription + '\'' + ", releaseDate=" + releaseDate + ", duration=" + duration + ", coverPhotoUrl='"
                + coverPhotoUrl + '\'' + ", trailerUrl='" + trailerUrl + '\'' + '}';
    }
}
