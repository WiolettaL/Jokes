package com.wostasz.jokes.controller;

import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.domain.PersonDTO;
import com.wostasz.jokes.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:8080")
@RequestMapping("/api")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/pAmount")
    public ResponseEntity<Long> getAllPersonsAmount() {
        return ResponseEntity.ok(service.getAllPersonsAmount());
    }

    @GetMapping("/higherAgeP")
    public ResponseEntity<List<Person>> getPersonsWithAgeHigherThanRequired(@RequestParam int requiredAge) {
        return ResponseEntity.ok(service.getPersonsWithAgeHigherThanRequired(requiredAge));
    }

    @GetMapping("/averageAge")
    public ResponseEntity<Double> getPersonsAverageAge(@RequestBody Person person) {
        return ResponseEntity.ok(service.getPersonsAverageAge(person));
    }

    @GetMapping("/totalHobbies")
    public ResponseEntity<List<HobbyEnum>> getAllHobbies() {
        return ResponseEntity.ok(service.getAllHobbies());
    }

}
