package com.wostasz.jokes.service;

import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//TODO
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public long getAllPersonsAmount() {
        return personRepository.count();
    }

    public List<Person> getPersonsWithAgeHigherThanRequired(int requiredAge) {

        List<Person> personList = personRepository.findAll();

        return personList.stream()
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
        // should return list of all hobbies from all people in db
        //tabela łącząca Person i HobbyEnum czy jak to ugryźć?
    }

    //should I write methods like createPerson(), updatePerson() etc?

}
