package com.wostasz.jokes.service;

import com.wostasz.jokes.csv.CSVHelper;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    PersonRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Person> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Person> tutorials = repository.findAll();

        return CSVHelper.tutorialsToCSV(tutorials);
    }

    public List<Person> getAllTutorials() {
        return repository.findAll();
    }

}
