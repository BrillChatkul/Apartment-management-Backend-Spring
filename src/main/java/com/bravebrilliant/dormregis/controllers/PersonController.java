package com.bravebrilliant.dormregis.controllers;

import com.bravebrilliant.dormregis.dto.person.CreatePersonDto;
import com.bravebrilliant.dormregis.dto.person.PersonDetailDto;
import com.bravebrilliant.dormregis.entities.Person;
import com.bravebrilliant.dormregis.service.person.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Person> getPerson(@PathVariable String firstName){
        Person person = this.personService.findByFirstName(firstName);
        return ResponseEntity.ok(person);
    }

    @PostMapping("/")
    public ResponseEntity<PersonDetailDto> createPerson(@RequestBody CreatePersonDto newPerson){
        PersonDetailDto person = this.personService.createPerson(newPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
}
