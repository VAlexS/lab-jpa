package com.example.lab_jpa.repositories;

import com.example.lab_jpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {


}
