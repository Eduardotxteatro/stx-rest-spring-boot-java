package com.github.Eduardotxteatro.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Eduardotxteatro.data.dto.PersonDTO;
import com.github.Eduardotxteatro.exception.ResourceNotFoundException;
import static com.github.Eduardotxteatro.mapper.ObjectMapper.parseListObjects;
import static com.github.Eduardotxteatro.mapper.ObjectMapper.parseObject;
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

    public List<PersonDTO> findeAll(){
        logger.info("Finding all people!");

        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findeById(Long id){

        logger.info("Finding one person!");//para acompanhar o que está acontecendo no sistema e perceber falhas.

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(Person person){
        logger.info("Creating one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
        
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(Person person){
        logger.info("Updating one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
        
        Person entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + person.getId()));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person!"); //para acompanhar o que está acontecendo no sistema e perceber falhas.
    
    
        Person entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        repository.delete(entity);
    }
}   

