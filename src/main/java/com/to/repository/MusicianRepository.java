package com.to.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.to.Band;
import com.to.Musician;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

	@Query("select b from Band b join b.musicians m where m.id = ?1")
    List<Band> findAllBandsByMusicianId(long musicianId);
}
