package com.codegym.validation_music.controller;

import com.codegym.validation_music.model.Song;
import com.codegym.validation_music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public String getAllSongs(Model model) {
        model.addAttribute("songs", songService.getAllSongs());
        return "song-list";
    }

    @GetMapping("/add")
    public String showAddForm(Song song) {
        return "add-song";
    }

    @PostMapping("/add")
    public String addSong(@Validated Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-song";
        }
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Song song = songService.getSongById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid song Id:" + id));
        model.addAttribute("song", song);
        return "update-song";
    }

    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable("id") long id, @Validated Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            song.setId(id);
            return "update-song";
        }
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") long id, Model model) {
        Song song = songService.getSongById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid song Id:" + id));
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
