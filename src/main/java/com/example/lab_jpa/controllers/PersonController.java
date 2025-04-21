package com.example.lab_jpa.controllers;

import com.example.lab_jpa.models.Person;
import com.example.lab_jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/api/hello") // esta anotación indica que el siguiente método manejará un
    // GET al endpoint /hello
    public String hello(){
        return "Hello Word";
    }

    @GetMapping("/api/persons")
    public List<Person> getAllStudents(){
        return personRepository.findAll();
    }

}
