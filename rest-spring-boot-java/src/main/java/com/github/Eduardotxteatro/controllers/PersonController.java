package com.github.Eduardotxteatro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.Eduardotxteatro.model.Person;
import com.github.Eduardotxteatro.services.PersonServices;

@RestController
@RequestMapping("/person") 
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findeById(@PathVariable("id") String id){
        return services.findeById(id);
        
    }
}
