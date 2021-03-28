package com.wostasz.jokes.controller;

import com.wostasz.jokes.client.JokeClient;
import com.wostasz.jokes.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("api/jt")
public class JokeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    private JokeClient jokeClient;

    @Autowired
    private JokeService jokeService;

    @GetMapping(value = "/joke")
    public Mono<String> getJoke(@RequestParam("first") String first, @RequestParam("last") String last) {

        LOGGER.info("Started method getJoke()");
        return jokeService.getJokeAsync(first, last);
    }
}
