package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import com.google.gson.Gson;

@RestController
@RequestMapping("/Movies")
public class MoviesController {
    private List<Movie> moviesList = new ArrayList<>(List.of(
        new Movie("LionKing", 10, new HashSet<>(Set.of(new Actor("MUFASA", 8)))),
        new Movie("ReleaseShuli", 9, new HashSet<>(Set.of(new Actor("Shalom Michashvili", 8))))
    ));


    @GetMapping
    public List<Movie> getMovies() {
        return moviesList;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie newMovie) {
        moviesList.add(newMovie);
        return newMovie;
    }

    @PutMapping("/{index}")
    public Movie updateMovie(@PathVariable int index, @RequestBody Movie newMovie) {
        if (index >= 0 && index < moviesList.size()) {
            moviesList.set(index, newMovie);
            return newMovie;
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    @DeleteMapping("/{index}")
    public Movie deleteMovie(@PathVariable int index) {
        if (index >= 0 && index < moviesList.size()) {
            return moviesList.remove(index);
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }
}
