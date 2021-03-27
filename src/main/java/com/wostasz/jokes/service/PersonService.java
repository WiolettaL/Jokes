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

    //zwróci liczbę wszystkich osób
    public long getAllPersonsAmount() {
        return personRepository.count();
    }

    //zwróci liczbę osób o wieku powyżej zadanej wartości
    public List<Person> getPersonsWithAgeHigherThanRequired(int requiredAge) {

        List<Person> people = personRepository.findAll();

        List<Person> personList = people.stream()
                .filter(x -> x.getAge() > requiredAge)
                .collect(Collectors.toList());

        return personList;
    }

    //zwróci średni wiek wszystkich osób
    public Double getPersonsAverageAge(Person person) {
        Optional<Person> optionalPersons = personRepository.findAll(person.getName());

        return optionalPersons
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));

    }

}
