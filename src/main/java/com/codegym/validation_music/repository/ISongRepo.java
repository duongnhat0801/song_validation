package com.codegym.validation_music.repository;

import com.codegym.validation_music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepo extends JpaRepository <Song, Long>  {
}
