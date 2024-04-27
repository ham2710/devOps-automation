package com.to.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.to.Band;
import com.to.Musician;
import com.to.Person;
import com.to.repository.MusicianRepository;
import com.to.repository.PersonRepository;
import com.to.repository.model.CreateMusicianRequest;

@Service
public class MusicianService {

	private final MusicianRepository musicianRepository;

    private final PersonRepository personRepository;

    public MusicianService(MusicianRepository musicianRepository, PersonRepository personRepository) {
        this.musicianRepository = musicianRepository;
        this.personRepository = personRepository;
    }

    public Musician createMusician(CreateMusicianRequest createMusicianRequest) {
        return musicianRepository.save(mapToMusician(createMusicianRequest));
    }

    public Optional<Musician> getMusician(long id) {
        return musicianRepository.findById(id);
    }

    private Musician mapToMusician(CreateMusicianRequest createRequest) {
        Musician musician = new Musician();
        Person person = new Person();
        person.setFirstName(createRequest.firstName());
        person.setLastName(createRequest.lastName());
        person.setEmail(createRequest.email());
        person.setAge(createRequest.age());
        personRepository.save(person);
        musician.setPerson(person);
        return musician;
    }

    public List<Band> getBandsByMusicianId(long musicianId) {
        return musicianRepository.findAllBandsByMusicianId(musicianId);
    }

}
