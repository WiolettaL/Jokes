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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Value("${resource.path.InputDirectory}")
    private String path;

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

    public List<String[]> getPersonsFromCSVFile(Optional<Person> byName) throws IOException, CsvException {
        List<String[]> csvValues;

        System.out.println(path);
        File file = new File(path);

        MultipartFile multipartFile = new MockMultipartFile("test.csv", new FileInputStream(file));

        System.out.println(file.getAbsolutePath());

        List<ArrayList<String>> responseList = new ArrayList<>();
        try (
                InputStream input = multipartFile.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input))
        ){
            bufferedReader.lines().forEach(value -> {
                String[] data = value.split(",",-1);
                responseList.add(new ArrayList<>(Arrays.asList(data)));
            });
        } catch (IOException e) {
            logger.error("Data not found. Exception message: " + e);
        }

        System.out.println(responseList.get(1).toString());

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            csvValues = reader.readAll();
            csvValues.forEach(x -> System.out.println(Arrays.toString(x)));
        }
        return csvValues;
    }

}
