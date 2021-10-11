package com.vishwa.mbs.daos;

import com.vishwa.mbs.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * All the CRUD operations will be available now
 */
public interface MovieDao extends JpaRepository<Movie, Integer > {

    //We can define the signature of the methods in this interface
    //Follow some naming conventions

    // find<EntityName>By<ColumnName>
    // I want to provide support to search by name
    public Movie findMovieByMovieName(String movieName);

    // I want to search based on both name and duration
    public Movie findMovieByMovieNameAndDuration(String movieName , int duration);

    //I want to search based on conditions
    public List<Movie> findByDurationGreaterThanEqual(int duration);

    public List<Movie> findByMovieNameContaining(String movieString);

    public List<Movie> findByMovieNameIgnoreCase(String movien);
}
