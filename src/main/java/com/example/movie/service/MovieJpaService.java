/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    private MovieJpaRepository serv;

    @Override
    public Movie updateMovie(int movieId, Movie son) {
        try {
            Movie f = serv.findById(movieId).get();
            if (son.getMovieName() != null) {
                f.setMovieName(son.getMovieName());
            }
            if (son.getLeadActor() != null) {
                f.setLeadActor(son.getLeadActor());
            }

            serv.save(f);
            return f;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Movie> getMovie() {
        List<Movie> MovieColl = serv.findAll();
        ArrayList<Movie> arr = new ArrayList<>(MovieColl);

        return arr;
    }

    @Override
    public Movie addMovie(Movie so) {
        serv.save(so);
        return so;
    }

    @Override
    public Movie getMoviebyId(int movieId) {
        try {
            Movie ks = serv.findById(movieId).get();
            return ks;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delMovie(int movieId) {
        try {

            serv.deleteById(movieId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
