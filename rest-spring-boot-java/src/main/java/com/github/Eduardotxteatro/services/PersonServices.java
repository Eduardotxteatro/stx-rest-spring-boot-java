package com.github.Eduardotxteatro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.github.Eduardotxteatro.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findeAll(){
        List<Person> persons = new ArrayList<Person>();

        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findeById(String id){

        logger.info("Finding one person!");

        //Ponto em que acessaceremos o banco de dados para buscar a pessoa pelo id, mas como não temos um banco de dados, vamos criar uma pessoa fictícia.
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Paul");
        person.setLastName("Di'Anno");
        person.setAddress("Rua 2, 35R, London, UK");
        person.setGender("Male");
        return person;
    }



    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstName" + i);
        person.setLastName("lastName" + i);
        person.setAddress("some adress in Brasil");
        person.setGender("Male");
        return person;
    }
}   

