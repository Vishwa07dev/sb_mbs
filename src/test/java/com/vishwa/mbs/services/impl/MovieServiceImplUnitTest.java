package com.vishwa.mbs.services.impl;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.exceptions.MovieDetailsNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class MovieServiceImplUnitTest {

    /**
     * this will create a mocked MovieDao
     */
    @Mock
    private MovieDao movieDao ;

    /**
     * I need to crate a movieServiceObjet which uses mocked MovieDao
     */
    @InjectMocks
    private MovieServiceImpl movieService;


    private Movie movie ;

    private Movie savedMovie ;

    @BeforeEach
    public void beforeEach(){
        movie = new Movie();
        movie.setDuration(150);
        movie.setMovieName("Koi Mil Gya");
        movie.setMovieDescription("Awesome movie by Jadoo");
        movie.setTrailerUrl("trailer_url");
        movie.setCoverPhotoUrl("cover_photo_url");
        movie.setReleaseDate(LocalDateTime.of(2021,03,04,05,15,16));


        savedMovie = new Movie();
        savedMovie.setMovieId(1);
        savedMovie.setDuration(150);
        savedMovie.setMovieName("Koi Mil Gya");
        savedMovie.setMovieDescription("Awesome movie by Jadoo");
        savedMovie.setTrailerUrl("trailer_url");
        savedMovie.setCoverPhotoUrl("cover_photo_url");
        savedMovie.setReleaseDate(LocalDateTime.of(2021,03,04,05,15,16));


    }

    /**
     * Test the method acceptMovieDetails
     */
    @Test
    public void testAcceptMovieDetails(){

        // We need to create the data -- in the beforeEach method

        //Define the behaviour of mocked movieDao
        Mockito.when(movieDao.save(movie)).thenReturn(savedMovie);

        // We need to execute the method
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        // We need to check if the method returned the correct result
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals(1,savedMovie.getMovieId());
    }

    /**
     * Write the unit test for the method : getMovieDetails
     */
    @Test
    public void testGetMovieDetails() throws MovieDetailsNotFoundException {

        //Setup the data

        //Define the behaviour for mock
        Mockito.when(movieDao.findById(1)).thenReturn(Optional.of(savedMovie));

        // Execute the method
        Movie savedMovie = movieService.getMovieDetails(1);
        //Assertion
        Assertions.assertNotNull(savedMovie);
    }

}
