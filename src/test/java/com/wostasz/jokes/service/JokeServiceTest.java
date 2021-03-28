package com.wostasz.jokes.service;

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
//NPE !

//    @Test
//    public void getJokeAsync() {
//        String joke = service.getJokeAsync("Margaret", "25")
//                .block(Duration.ofSeconds(2));
//        logger.info(joke);
//        assertTrue(joke.contains("Margaret") || joke.contains("25"));
//    }

    //Throws NPE WHY?????

  //  @Test
 //   void getJokeAsync() {

//        Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);
//
//        String first = "Anna";
//        String last = "21";
//        Mono<String> joke = service.getJokeAsync(first, last);
//        String jokeString = joke.toString();
//
//        logger.info(jokeString);
//
//        assertTrue(jokeString.contains(first) || jokeString.contains(last));

 //   }
}