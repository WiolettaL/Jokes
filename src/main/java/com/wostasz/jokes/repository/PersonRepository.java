package com.wostasz.jokes.repository;

import com.wostasz.jokes.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Override
    List<Person> findAll();

    Person findByName(String name);

}