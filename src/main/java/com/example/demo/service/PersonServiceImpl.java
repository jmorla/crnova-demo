package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person fetchPerson(Integer id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public void createPerson(Person person) {
        Optional<Person> maybePerson = personRepository.findById(person.getId());
        if(maybePerson.isPresent()) {
            throw new IllegalArgumentException("Person already exists by id: " + person.getId());
        }

        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository
                .findById(person.getId()).orElseThrow(PersonNotFoundException::new);

        personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        personRepository.delete(person);
    }
}
