package com.wostasz.jokes.service;

import com.wostasz.jokes.domain.HobbyEnum;
import com.wostasz.jokes.domain.Person;
import com.wostasz.jokes.exception.JokeTellerNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class JokeServiceTest {

    @InjectMocks
    private JokeService service;


    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJokeAsync() throws JokeTellerNotFoundException {

        Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

        Mono<String> joke = service.getJokeForPerson("Anna", "25");
        String jokeString = joke.toString();

        logger.info(jokeString);

        assertTrue(jokeString.contains("Anna") || jokeString.contains("25"));
    }

    @Test
    public void getJokeAsyncTest() throws JokeTellerNotFoundException {

        Person person = new Person("Anna", 30, HobbyEnum.Cooking);

        String joke = service.getJokeForPerson("Anna", "30")
                .block(Duration.ofSeconds(2));
        logger.info(joke);
        assertTrue(joke.contains("Anna") || joke.contains("30"));
    }
}