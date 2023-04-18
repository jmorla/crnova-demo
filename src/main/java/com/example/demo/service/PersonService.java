package com.example.demo.service;

import com.example.demo.domain.Person;

public interface PersonService {

    Person fetchPerson(Integer id);

    void createPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Integer id);

}
