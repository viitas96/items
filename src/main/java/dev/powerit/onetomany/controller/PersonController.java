package dev.powerit.onetomany.controller;

import dev.powerit.onetomany.model.Person;
import dev.powerit.onetomany.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> index(){
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
    }
}
