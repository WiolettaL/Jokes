package com.wostasz.jokes.service;

import com.wostasz.jokes.client.JokeResponse;
import com.wostasz.jokes.controller.JokeController;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JokeService {

    private final WebClient client;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    private RestTemplate template;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    public JokeService(WebClient.Builder builder) {
        client = builder.baseUrl("http://api.icndb.com/jokes/random").build();
    }

    @SneakyThrows
    public Mono<String> getJokeAsync(String first, String last) {
        String base = "http://api.icndb.com/jokes/random";

        String url = String.format("%s&firstName=%s&lastName=%s", base, first, last);

        Optional<Person> optionalPerson = personRepository.findByName(first);

        List<String[]> personList = personService.getPersonsFromCSVFile(optionalPerson);

        List<String> header = personList.size() > 0 ? Arrays.asList(personList.get(0) ): null;

        System.out.println("????????????????????????????????????????????????????????????");
        System.out.println(header != null ? header.toString() : "Header is null");

        if(header == null)
            return null;

        int firstNameIndex = header.indexOf("Name");
        int lastNameIndex = header.indexOf("Age");

        int index = -1;

        for (String[] strings : personList) {
            if(strings[firstNameIndex].equals(first) && strings[lastNameIndex].equals(last))
                index = personList.indexOf(strings);
        }
        final int finalIndex = index;

        //if(finalIndex > -1){
            return client.get()
                    .uri(uriBuilder -> uriBuilder.path("/jokes/random")
                            .queryParam("firstName", personList.get(finalIndex)[firstNameIndex])
                            .queryParam("lastName", String.valueOf(personList.get(finalIndex)[lastNameIndex]))
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(JokeResponse.class)
                    .map(jokeResponse -> jokeResponse.getValue().getJoke());

    }

}