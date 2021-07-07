package com.wostasz.jokes.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Value("${resource.path.InputDirectory}")
    private String csvPath;

    public long getAllPersonsAmount() {
        return personRepository.count();
    }

    public List<Person> getPersonsWithAgeHigherThanRequired(int requiredAge) {

        List<Person> personList = personRepository.findAll();

        return personList.stream()
                .filter(person -> person.getAge() > requiredAge)
                .collect(Collectors.toList());

    }

    public Double getPersonsAverageAge(Person person) {

        List<Person> optionalPersons = personRepository.findAll();

        return optionalPersons
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));

    }

    public List<HobbyEnum> getAllHobbies() {

        List<Person> optionalPersons = personRepository.findAll();

        return optionalPersons.stream()
                .map(Person::getHobbyEnum)
                .collect(Collectors.toList());

    }

    public List<String> getPersonsFromFile() throws IOException {

        File file = new File(csvPath);

        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] array = line.split(";");
            System.out.println(array[0]+" "+array[array.length-1]);
        }

        return lines;

    }

}
