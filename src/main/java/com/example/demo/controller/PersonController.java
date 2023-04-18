package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        Person person = personService.fetchPerson(id);
        return ResponseEntity.ok(person);
    }

    @PutMapping
    public ResponseEntity updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
