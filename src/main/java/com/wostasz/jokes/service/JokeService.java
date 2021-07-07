package com.wostasz.jokes.service;

import com.wostasz.jokes.dto.response.JokeResDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JokeService {

    private static String URL = "http://api.icndb.com/jokes/random";

    private final PersonService personService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public JokeService(PersonService personService,
                       RestTemplate restTemplate) {
        this.personService = personService;
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    public String getJokeForPerson(String first, String last) {

        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("firstName", first)
                .queryParam("lastName", last)
                .build();

        JokeResDTO jokeResDTO = restTemplate.getForObject(uriBuilder.toUriString(), JokeResDTO.class);

        if (personService.getPersonsFromFile().contains(first)) {
            return jokeResDTO.getType().contains("success") ? jokeResDTO.getValue().toString() : null;
        } else {
            return "NO SUCH PERSON";
        }

    }

}