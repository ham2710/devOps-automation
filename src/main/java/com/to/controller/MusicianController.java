package com.to.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.Band;
import com.to.Musician;
import com.to.exception.MusicianNotFoundException;
import com.to.repository.model.CreateMusicianRequest;
import com.to.service.MusicianService;

@RestController
@RequestMapping("/api/v1/musicians")
public class MusicianController {

    private final MusicianService musicianService;

    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }


    @PostMapping
    public Musician createMusician(@RequestBody CreateMusicianRequest createMusicianRequest) {
        return musicianService.createMusician(createMusicianRequest);
    }

    @GetMapping("/{id}")
    public Musician getMusician(@PathVariable long id) {
        return musicianService.getMusician(id).orElseThrow(() -> new MusicianNotFoundException());
    }

    @GetMapping("/bands/{musicianId}")
    public List<Band> getBands(@PathVariable long musicianId) {
        return musicianService.getBandsByMusicianId(musicianId);
    }

}