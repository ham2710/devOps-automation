package com.to.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.to.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
