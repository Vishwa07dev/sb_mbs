package com.vishwa.mbs.services.impl;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.exceptions.MovieDetailsNotFoundException;
import com.vishwa.mbs.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        LOGGER.debug("Movie object passed for creation is : "+ movie);
        LOGGER.info("acceptMovieDetails method is triggered");
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
        LOGGER.debug("Movie is passed for searching movie is  : " + movieId);
        LOGGER.info("getMovieDetails method is triggered");
        Movie savedMovie = movieDao.findById(movieId).orElseThrow(
                ()
                        -> {
                    LOGGER.error("Movie was not found for the id : " + movieId);
                    return new MovieDetailsNotFoundException("Movie details not found for the movie id : " + movieId);
                }
        );
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
