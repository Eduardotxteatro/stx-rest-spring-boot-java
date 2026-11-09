package com.github.Eduardotxteatro.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.Eduardotxteatro.data.dto.v2.PersonDTOV2;
import com.github.Eduardotxteatro.model.Person;

@Service 
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person){
        PersonDTOV2 dto = new PersonDTOV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthday(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDTOtoEntity(PersonDTOV2 person){
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //entity.setBirthday(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;
    }
}
