package com.wostasz.jokes.service;

import com.wostasz.jokes.entity.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public long getAllPersonsAmount() {
        return personRepository.count();
    }

    public List<Person> getPersonsWithAgeHigherThanRequired(int requiredAge) {

        List<Person> people = personRepository.findAll();

        return people.stream()
                .filter(x -> x.getAge() > requiredAge)
                .collect(Collectors.toList());
    }

    public Double getPersonsAverageAge(Person person) {
        List<Person> optionalPersons = personRepository.findAll();

        return optionalPersons
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));
    }

    public void getAllPersonsHobby() {

    }


}
