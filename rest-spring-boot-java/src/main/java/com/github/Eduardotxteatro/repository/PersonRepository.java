package com.github.Eduardotxteatro.repository;

import com.github.Eduardotxteatro.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
