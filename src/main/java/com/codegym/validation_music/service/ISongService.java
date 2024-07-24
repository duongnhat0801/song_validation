package com.codegym.validation_music.service;

import com.codegym.validation_music.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> getAllSongs();
    Optional<Song> getSongById(Long id);
    Song saveSong(Song song);
    void deleteSong(Long id);
}
