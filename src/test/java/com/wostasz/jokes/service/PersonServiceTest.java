package com.wostasz.jokes.service;

import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonService service;

    @Test
    void getAllPersonsAmountTest() {
//        //Given
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("Anna", 30, HobbyEnum.Cooking));
//        personList.add(new Person("Tom", 25, HobbyEnum.Music));
//        personList.add(new Person("Bob", 28, HobbyEnum.Gaming));
//
//        //When
//        Mockito.when(repository.findAll()).thenReturn(personList);
//        long amount = service.getAllPersonsAmount();
//
//        //Then
//        Assertions.assertTrue(amount == 3);
    }

    @Test
    void getPersonsWithAgeHigherThanRequiredTest() {
    }

    @Test
    void getPersonsAverageAgeTest() {
    }

    @Test
    void getAllHobbiesTest() {
    }
}