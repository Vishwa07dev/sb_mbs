package com.vishwa.mbs.services.impl;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.exceptions.MovieDetailsNotFoundException;
import com.vishwa.mbs.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    /**
     * If correct id passed, return the correct Movie
     *
     * else
     *
     * throw the exception  - MovieDetailsNotFoundException
     *
     * @param movieId
     * @return
     */
    @Override
    public Movie getMovieDetails(int movieId) throws MovieDetailsNotFoundException {
        Movie savedMovie = movieDao.findById(movieId).orElseThrow(()
                -> new MovieDetailsNotFoundException("Movie details not found for the movie id : "+ movieId));
        return savedMovie;
    }

    @Override
    public Movie updateMovieDetails(int movieId, Movie movie) throws MovieDetailsNotFoundException {
        //First fetch the saved movie
        Movie savedMovie = movieDao.findById(movieId).orElseThrow(()
                -> new MovieDetailsNotFoundException("Movie details not found for the movie id : "+ movieId));

        //Update the saved movie object
        if(movie.getMovieName()!=null){
            savedMovie.setMovieName(movie.getMovieName());
        }
        if(movie.getDuration()>0){
            savedMovie.setDuration(movie.getDuration());
        }

        if(movie.getMovieDescription()!=null){
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }

        if(movie.getCoverPhotoUrl()!=null){
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }

        if(movie.getTrailerUrl()!=null){
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }

        if(movie.getReleaseDate()!=null){
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        if(movie.getStatus()!=null){
            savedMovie.setStatus(movie.getStatus());
        }

        //Save it back in the database

       return movieDao.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {
        movieDao.deleteById(id);
        return true;
    }

    @Override
    public List<Movie> getAllMovieDetails() {
        return movieDao.findAll();
    }
}
