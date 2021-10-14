package com.vishwa.mbs.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieTheatreId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" + "movieTheatreId=" + movieTheatreId + ", movie=" + movie + ", theatre=" + theatre + '}';
    }
}
