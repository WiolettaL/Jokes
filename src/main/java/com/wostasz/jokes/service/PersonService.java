package com.wostasz.jokes.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Value("${ressource.path.InputDirectory}")
    private String path;

    public long getAllPersonsAmount() {
        return personRepository.count();
    }

    public List<String[]> getPersonsFromCSVFile(Optional<Person> byName) throws IOException, CsvException {
        List<String[]> r;

        System.out.println(path);
        File file = new File(path);

        MultipartFile multipartFile = new MockMultipartFile("test.csv", new FileInputStream(new File(path)));

        System.out.println(file.getAbsolutePath());

        System.out.println("-------------------");
        List<ArrayList<String>> res = new ArrayList<>();
        try (
                InputStream input = multipartFile.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input))
        ){
            bufferedReader.lines().forEach(value -> {
                String[] data = value.split(",",-1);
                res.add(new ArrayList<String>(Arrays.asList(data)));
            });
        } catch (IOException e) {

        }

        System.out.println("-------------------");
        System.out.println(res.get(1).toString());

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
        return r;
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

    public List<HobbyEnum> getAllHobbies() {

        List<Person> optionalPersons = personRepository.findAll();

        return optionalPersons.stream()
                .map(Person::getHobbyEnum)
                .collect(Collectors.toList());
    }

}
