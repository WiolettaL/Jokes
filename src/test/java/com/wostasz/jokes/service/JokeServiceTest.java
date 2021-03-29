package com.wostasz.jokes.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class JokeServiceTest {

    @InjectMocks
    JokeService service;

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJokeForPersonTest1() {

        Mono<String> joke = service.getJokeForPerson("Anna", "25");
        String jokeString = joke.toString();

        logger.info(jokeString);

        assertTrue(jokeString.contains("Anna") || jokeString.contains("25"));
    }

}