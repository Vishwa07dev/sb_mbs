package com.vishwa.mbs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vishwa.mbs.entities.Status;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Objects;

public class MovieDTO {

    /**
     * movie_id
     */
    @JsonProperty("movie_id")
    private int movieId ;

    @JsonProperty("movie_name")
    private String movieName;


    @JsonProperty("movie_desc")
    private String movieDescription;

    @JsonProperty("release_date")
    private LocalDateTime releaseDate;

    private int duration;

    @JsonProperty("cover_photo_url")
    private String coverPhotoUrl;

    @JsonProperty("trailer_url")
    private String trailerUrl;

    @JsonProperty("status_id")
    private int  statusId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return movieId == movieDTO.movieId && duration == movieDTO.duration && Objects.equals(movieName, movieDTO.movieName) && Objects.equals(movieDescription, movieDTO.movieDescription) && Objects.equals(releaseDate, movieDTO.releaseDate) && Objects.equals(coverPhotoUrl, movieDTO.coverPhotoUrl) && Objects.equals(trailerUrl, movieDTO.trailerUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, movieDescription, releaseDate, duration, coverPhotoUrl, trailerUrl);
    }
}
