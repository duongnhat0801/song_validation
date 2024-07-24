package com.codegym.validation_music.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.data.annotation.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Song name is required")
    @Size(max = 800, message = "Song name must be less than 800 characters")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Song name contains invalid characters")
    private String name;

    @NotBlank(message = "Artist is required")
    @Size(max = 300, message = "Artist must be less than 300 characters")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Artist contains invalid characters")
    private String artist;

    @NotBlank(message = "Genre is required")
    @Size(max = 1000, message = "Genre must be less than 1000 characters")
    @Pattern(regexp = "^[^@;=+\\-]+$", message = "Genre contains invalid characters")
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
