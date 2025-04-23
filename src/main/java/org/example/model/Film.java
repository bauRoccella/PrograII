package org.example.model;

import java.util.Objects;

public class Film {
    private final String title;
    private final int duration;
    private final Genre genre;
    private final int rating;

    public Film(String title, int duration, Genre genre, int rating) {
        this.title = title;
        this.duration = duration; // min en int
        this.genre = genre;
        this.rating = rating; // rating podria ser puntaje o clasificacion segun la traduccion
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title + " (" + duration + " min, " + genre + ", " + rating + ")";
    }
}