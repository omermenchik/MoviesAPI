package com.example.demo;

import java.util.HashSet;

public class Movie {
    private String name;
    private int rating;
    private HashSet<Actor> movieActors;

    public Movie(String name, int rating, HashSet<Actor> movieActors) {
        this.name = name;
        this.rating = rating;
        this.movieActors = movieActors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie{name='").append(name)
          .append("', rating=").append(rating)
          .append(", actors=[");

        if (movieActors != null && !movieActors.isEmpty()) {
            for (Actor currActor : movieActors) {
                sb.append(currActor.getName()).append(", ");
            }
            // מוחק פסיק ורווח אחרונים
            sb.setLength(sb.length() - 2);
        }

        sb.append("]}");
        return sb.toString();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public HashSet<Actor> getMovieActors() {
        return movieActors;
    }
    public void setMovieActors(HashSet<Actor> movieActors) {
        this.movieActors = movieActors;
    }

    public void addActorToMovie(Actor actor) {
        movieActors.add(actor);
    }
}
