package com.wostasz.jokes.controller;

import com.wostasz.jokes.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("api/jt")
public class JokeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    private JokeService jokeService;

    @GetMapping(value = "/joke")
    public String getJokeForPerson(@RequestParam("first") String first, @RequestParam("last") String last) {
        LOGGER.info("Started method getJokeForPerson().");
        return jokeService.getJokeForPerson(first, last);

    }
}
