package com.wostasz.jokes.service;

import com.wostasz.jokes.client.JokeResponse;
import com.wostasz.jokes.client.JokeValue;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class JokeService {

    private final WebClient client;

    @Autowired
    private RestTemplate template;

    private JokeValue jokeValue;

    @Autowired
    private PersonRepository personRepository;


    @Autowired
    public JokeService(WebClient.Builder builder) {
        client = builder.baseUrl("http://www.icndb.com/api/").build();
    }

    public Mono<String> getJokeAsync(String first, String last) {
        String base = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

        String url = String.format("%s&firstName=%s&lastName=%s", base, first, last);

        Optional<Person> optionalPerson = personRepository.findByName(first);

        try {
            if (optionalPerson.isPresent()) {
                return client.get()
                        .uri(uriBuilder -> uriBuilder.path("/jokes/random")
                                .queryParam("limitTo", "[nerdy]")
                                .queryParam("firstName", optionalPerson.get().getName())
                                .queryParam("lastName", String.valueOf(optionalPerson.get().getAge()))
                                .build())
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(JokeResponse.class)
                        .map(jokeResponse -> jokeResponse.getValue().getJoke());
            }
        } catch (HttpServerErrorException e) {
            throw e;
        }
        return null;
    }
}
