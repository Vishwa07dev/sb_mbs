package com.vishwa.mbs;

import com.vishwa.mbs.daos.MovieDao;
import com.vishwa.mbs.entities.Movie;
import com.vishwa.mbs.entities.Status;
import com.vishwa.mbs.exceptions.StatusDetailsNotFoundException;
import com.vishwa.mbs.services.InitService;
import com.vishwa.mbs.services.MovieService;
import com.vishwa.mbs.services.StatusService;
import com.vishwa.mbs.services.impl.MovieServiceImpl;
import com.vishwa.mbs.services.impl.StatusServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Main class of the SpringBoot
 */
@SpringBootApplication
public class MbsApplication {

	/**
	 * Writing logs
	 * Initialize the logger
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MbsApplication.class);

	public static void main(String[] args) throws StatusDetailsNotFoundException {

		SpringApplication.run(MbsApplication.class, args);



	}

	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			System.out.println("This will be executed as soon as the application is started");
			initService.init();
		};
	}

}
