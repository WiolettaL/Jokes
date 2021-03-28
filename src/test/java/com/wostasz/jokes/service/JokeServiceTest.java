package com.wostasz.jokes.service;

import com.wostasz.jokes.exception.JokeTellerNotFoundException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    private JokeService service;

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJokeAsync() throws JokeTellerNotFoundException {

        Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

        Mono<String> joke = service.getJokeAsync("Anna", "25");
        String jokeString = joke.toString();

        logger.info(jokeString);

        assertTrue(jokeString.contains("Anna") || jokeString.contains("25"));
    }
}