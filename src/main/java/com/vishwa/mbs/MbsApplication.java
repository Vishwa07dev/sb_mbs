package com.vishwa.mbs;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

/**
 * Main class of the SpringBoot
 */
@SpringBootApplication
public class MbsApplication {

	public static void main(String[] args) {

		//I have got the hold of Application Context
		ApplicationContext ctx = SpringApplication.run(MbsApplication.class, args);

		//Got the hold of MovieDao bean
	    MovieDao movieDao = ctx.getBean(MovieDao.class);

		System.out.println(movieDao);

		System.out.println("Hello Studnets ");

		/**
		 * Add a new movie to DB
		 */

		Movie movie = new Movie();
		movie.setMovieName("shaangchi");
		movie.setMovieDescription("It's a great movie");
		movie.setReleaseDate(LocalDateTime.of(2021,6,27,5,30));
		movie.setDuration(150);
		movie.setCoverPhotoUrl("www.shaangchi/cover-photo-url");
		movie.setTrailerUrl("www.shaangchi/trailer-url");

		System.out.println("<-----  Before movie is stored -------->");
		System.out.println(movie);

		System.out.println("<--- After movie is stored ------>");

		Movie savedMovie = movieDao.save(movie); // provided by default

		System.out.println(savedMovie);

		System.out.println("<---- Let's search the movie based on id ---->");

		Movie searchedMovie = movieDao.findById(savedMovie.getMovieId()).get();

		System.out.println(searchedMovie);

		System.out.println("<---- I want to update the movie record --->");
		System.out.println("Actual Movie duration : " + searchedMovie.getDuration());


		searchedMovie.setDuration(250);

		Movie updatedMovie = movieDao.save(searchedMovie);

		System.out.println("Updated movie duration : " + searchedMovie.getDuration());


		System.out.println("<----- Search by the movie name ---->");
		Movie foundByName = movieDao.findMovieByMovieName(updatedMovie.getMovieName());

		System.out.println(foundByName);

		System.out.println("<------- Let's delete the record as well --------->");

		movieDao.deleteById(updatedMovie.getMovieId());




	}

}
