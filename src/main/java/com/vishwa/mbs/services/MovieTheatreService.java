package com.vishwa.mbs.services;


import com.vishwa.mbs.entities.MovieTheatre;
import com.vishwa.mbs.exceptions.MovieDetailsNotFoundException;
import com.vishwa.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.mbs.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
}