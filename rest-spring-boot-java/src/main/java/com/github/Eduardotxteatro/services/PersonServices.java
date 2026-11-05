package com.github.Eduardotxteatro.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Eduardotxteatro.exception.ResourceNotFoundException;
import com.github.Eduardotxteatro.model.Person;
import com.github.Eduardotxteatro.repository.PersonRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;   

    public List<Person> findeAll(){
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findeById(Long id){

        logger.info("Finding one person!");//para acompanhar o que está acontecendo no sistema e perceber falhas.

        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
    }

    public Person create(Person person){
        logger.info("Creating one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
        
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
        
        Person entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + person.getId()));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
    
    
        Person entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        repository.delete(entity);
    }
}   

