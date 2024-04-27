package com.to.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to.Band;
import com.to.exception.BandNotFoundException;
import com.to.repository.model.BandCreationRequest;
import com.to.repository.model.HealthStatus;
import com.to.service.BandService;

@RestController
@RequestMapping("/api/v1/bands")
public class BandController {

    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping("/health")
    public HealthStatus getHealthStatus() {
        return new HealthStatus(bandService.isHealthy());
    }

    @PostMapping
    public Band createBand(@RequestBody BandCreationRequest bandCreationRequest) {
        return bandService.createBand(bandCreationRequest);
    }

    @GetMapping("/{id}")
    public Band getBand(@PathVariable long id) {
        return bandService.getBand(id).orElseThrow(() -> new BandNotFoundException());
    }

    @PatchMapping("/{bandId}/musicians")
    public Band addMusiciansToBand(@PathVariable long bandId, @RequestBody List<Long> musicianIds) {
        return bandService.addMusiciansToBand(bandId, musicianIds).orElseThrow(() -> new BandNotFoundException());
    }

}
