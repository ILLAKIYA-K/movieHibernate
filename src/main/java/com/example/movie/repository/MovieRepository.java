// Write your code here

package com.example.movie.repository;

import java.util.*;

import com.example.movie.model.Movie;

public interface MovieRepository {
    ArrayList<Movie> getMovie();

    void delMovie(int movieId);

    Movie getMoviebyId(int movieId);

    Movie addMovie(Movie so);

    Movie updateMovie(int movieId, Movie son);
}