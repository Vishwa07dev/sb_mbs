package com.vishwa.mbs;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.entities.Status;
import com.vishwa.mbs.exceptions.StatusDetailsNotFoundException;
import com.vishwa.mbs.services.MovieService;
import com.vishwa.mbs.services.StatusService;
import com.vishwa.mbs.services.impl.MovieServiceImpl;
import com.vishwa.mbs.services.impl.StatusServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Main class of the SpringBoot
 */
@SpringBootApplication
public class MbsApplication {

	public static void main(String[] args) throws StatusDetailsNotFoundException {

		//I have got the hold of Application Context
		ApplicationContext ctx = SpringApplication.run(MbsApplication.class, args);

		//Let's test the status  service

		StatusService statusService = ctx.getBean(StatusServiceImpl.class);
		System.out.println("statusService bean : "+ statusService);
		Status status = new Status();
		status.setStatusName("RELEASED");
		statusService.acceptStatusDetails(status);

		Status status1 = new Status();
		status1.setStatusName("BLOCKED");
		statusService.acceptStatusDetails(status1);



		Status savedStatus = statusService.getStatusBasedOnId(1);

		System.out.println(savedStatus);

		//Get the list of all the statuses

		List<Status> savedStatuses = statusService.getAllStatuses();

		System.out.println(savedStatuses);


		Movie movie = new Movie();
		movie.setDuration(150);
		movie.setMovieName("Koi Mil Gya");
		movie.setMovieDescription("Awesome movie by Jadoo");
		movie.setTrailerUrl("trailer_url");
		movie.setCoverPhotoUrl("cover_photo_url");
		movie.setReleaseDate(LocalDateTime.of(2021,03,04,05,15,16));
		movie.setStatus(status);


		MovieService movieService = ctx.getBean(MovieServiceImpl.class);

		movieService.acceptMovieDetails(movie);

	}

}
