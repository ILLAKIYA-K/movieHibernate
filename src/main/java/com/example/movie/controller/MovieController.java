/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController

public class MovieController {
    @Autowired
    public MovieJpaService ser;

    @DeleteMapping("/movies/{movieId}")
    public void delMovie(@PathVariable("movieId") int movieId) {
        ser.delMovie(movieId);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMoviebyId(@PathVariable("movieId") int movieId) {
        return ser.getMoviebyId(movieId);
    }

    @GetMapping("/movies")
    public ArrayList<Movie> getMovie() {
        return ser.getMovie();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie so) {
        return ser.addMovie(so);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie son) {
        return ser.updateMovie(movieId, son);
    }

}