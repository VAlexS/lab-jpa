package com.example.lab_jpa.repositories;

import com.example.lab_jpa.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    @DisplayName("Guardar un estudiante en la base de datos")
    void testSave(){
        var person = new Person("John Doe", 30);
        personRepository.save(person);

        Optional<Person> personFound = personRepository.findById(1);

        System.out.println("=================");
        System.out.println("La persona que hemos encontrado es ");
        System.out.println(personFound);
        System.out.println("==================");

        assertTrue(personFound.isPresent());

        assertEquals(30, personFound.get().getAge());

        assertEquals("John Doe", personFound.get().getName());
    }

    @Test
    @DisplayName("Buscar todas las personas")
    void testFindAll(){
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Ditto", 30));
        persons.add(new Person("Victor Sanz", 25));
        persons.add(new Person("Veronica Perez", 22));
        persons.add(new Person("Paco Martinez", 40));

        personRepository.saveAll(persons);

        List<Person> personsSaved = personRepository.findAll();

        assertNotNull(personsSaved);

        System.out.println("=================");
        System.out.println("Las personas que has guardado en la base de datos son");
        System.out.println(personsSaved);
        System.out.println("==================");

        assertEquals("Ditto", personsSaved.get(1).getName());
        assertEquals(30, personsSaved.get(1).getAge());


    }

    @Test
    @DisplayName("Guardo y elimino una persona")
    void testSaveAndDelete(){
        var person = new Person("Javier Martinez", 29);

        personRepository.save(person);

        Optional<Person> personSaved = personRepository.findById(22);

        System.out.println("=================");
        System.out.println("La persona que has guardado es ");
        System.out.println(personSaved);
        System.out.println("==================");

        assertTrue(personSaved.isPresent());

        personRepository.delete(person);

        Optional<Person> personDeleted = personRepository.findById(22);

        assertFalse(personDeleted.isPresent());
    }

    @Test
    @DisplayName("Pruebo a modificar los datos de una persona")
    void testUpdate(){
        var person = new Person("Alberto Gonzalez", 50);

        personRepository.save(person);

        Optional<Person> personSaved = personRepository.findById(24);

        assertTrue(personSaved.isPresent());

        person.setName("Fernando Sanchez");
        person.setAge(40);

        personRepository.save(person);

        System.out.println("=================");
        System.out.println("La persona que has guardado con los datos modificados es ");
        System.out.println(personSaved);
        System.out.println("==================");

        assertEquals("Alberto Gonzalez", personSaved.get().getName());
        assertEquals(50, personSaved.get().getAge());



    }





}