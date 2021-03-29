
package com.wostasz.jokes.service;

import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class PersonServiceTest {

    @InjectMocks
    PersonService service;

    @Test
    void getAllPersonsAmountTest() {

        //Given
        PersonRepository repository = Mockito.mock(PersonRepository.class);
        Person person = new Person();
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        //When
        Mockito.when(repository.findAll()).thenReturn(personList);

        //Then
        Assertions.assertTrue(personList.size() > 0);
    }

    @Test
    void getPersonsWithAgeHigherThanRequiredTest() {

        //Given
        Person person1 = new Person("Anna", 20, HobbyEnum.Cooking);
        Person person2 = new Person("Adam", 25, HobbyEnum.Gaming);
        Person person3 = new Person("David", 30, HobbyEnum.Movies);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        //When
        int requiredAge = 25;

        List<Person> adult = personList.stream()
                .filter(person -> person.getAge() > requiredAge)
                .collect(Collectors.toList());

        //Then
        Assertions.assertTrue(adult.contains(person3));

    }

    @Test
    void getPersonsAverageAgeTest() {
        //Given
        Person person1 = new Person("Anna", 20, HobbyEnum.Cooking);
        Person person2 = new Person("Adam", 25, HobbyEnum.Gaming);
        Person person3 = new Person("David", 30, HobbyEnum.Movies);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        //When
        double people = personList.size();
        double average = (person1.getAge() + person2.getAge() + person3.getAge()) / people;

        //Then
        Assertions.assertTrue(average == 25);
    }

    @Test
    void getAllHobbiesTest() {
        //Given
        Person person1 = new Person("Anna", 20, HobbyEnum.Cooking);
        Person person2 = new Person("Adam", 25, HobbyEnum.Gaming);
        Person person3 = new Person("David", 30, HobbyEnum.Movies);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        //When
        List<HobbyEnum> hobbies = personList.stream()
                .map(Person::getHobbyEnum)
                .collect(Collectors.toList());

        //Then
        Assertions.assertTrue(hobbies.contains(HobbyEnum.Cooking));
    }
}