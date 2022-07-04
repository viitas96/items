package dev.powerit.onetomany.controller;

import dev.powerit.onetomany.model.Person;
import dev.powerit.onetomany.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
@Tag(name = "PersonController")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    @Operation(summary = "Get persons", responses = {
            @ApiResponse(description = "Get user success", responseCode = "200",
            content = @Content(mediaType = "application/JSON", schema = @Schema(implementation = Person.class)))
    })
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
