package com.vishwa.mbs.controllers;


import com.vishwa.mbs.dtos.MovieDTO;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.entities.Status;
import com.vishwa.mbs.exceptions.StatusDetailsNotFoundException;
import com.vishwa.mbs.services.MovieService;
import com.vishwa.mbs.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
/**
 * 127.0.0.1:7777/mbs/v1/movies
 * This controller class methods should get invoked
 *
 * root uri -> /mbs/v1 : will be same for all the resources
 */
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService ;

    @Autowired
    private StatusService statusService ;



    /**
     * I want to create a new movie
     *
     *     - new movie created will be saved to the db
     *
     *
     *     POST - 127.0.0.1:7777/mbs/v1/movies
     *     JSON request body {}   --> MovieDTO
     *
     *
     */
    @PostMapping
    public ResponseEntity createMovie(@RequestBody  MovieDTO movieDTO) throws StatusDetailsNotFoundException {

        /**
         * Save this movieDTO into daba
         *
         * 0. Create MovieEntity From MovieDTO
         *
         * 1.Use MovieService to save it
         */

        Movie movieEntity = convertMovieDTOtoEntity(movieDTO);

        Movie savedMovieEntity = movieService.acceptMovieDetails(movieEntity);

        MovieDTO responseBody = convertMovieEntityToDTO(savedMovieEntity);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }

    /**
     * Get all the movies created so far
     * @param savedMovieEntity
     * @return
     */

    @GetMapping
    public ResponseEntity getAllMovies(){
        List<Movie> movieList = movieService.getAllMovieDetails();

        List<MovieDTO> movieDTOS = new ArrayList<>();

        for(Movie movie : movieList){
            MovieDTO movieDTO = convertMovieEntityToDTO(movie);
            movieDTOS.add(movieDTO);
        }

        return new ResponseEntity(movieDTOS, HttpStatus.OK);
    }

    /**
     * PUT
     * GET based on id
     * DELETE
     *
     *
     *
     * @param savedMovieEntity
     * @return
     */


    private MovieDTO convertMovieEntityToDTO(Movie savedMovieEntity) {

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setDuration(savedMovieEntity.getDuration());
        movieDTO.setMovieId(savedMovieEntity.getMovieId());
        movieDTO.setMovieDescription(savedMovieEntity.getMovieDescription());
        movieDTO.setStatusId(savedMovieEntity.getStatus().getStatusId());
        movieDTO.setCoverPhotoUrl(savedMovieEntity.getCoverPhotoUrl());
        movieDTO.setTrailerUrl(savedMovieEntity.getTrailerUrl());
        movieDTO.setMovieName(savedMovieEntity.getMovieName());
        movieDTO.setReleaseDate(savedMovieEntity.getReleaseDate());
        return movieDTO ;
    }

    private Movie convertMovieDTOtoEntity(MovieDTO movieDTO) throws StatusDetailsNotFoundException {

        Movie movie=  new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setTrailerUrl(movieDTO.getTrailerUrl());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setCoverPhotoUrl(movieDTO.getCoverPhotoUrl());
        /**
         * Set the status of the movie
         */
        int statusId = movieDTO.getStatusId();
        Status status = statusService.getStatusBasedOnId(statusId);
        movie.setStatus(status);
        return movie ;
    }

}
