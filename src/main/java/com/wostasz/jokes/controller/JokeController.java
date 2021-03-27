package com.wostasz.jokes.controller;

import com.wostasz.jokes.client.JokeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/jt")
public class JokeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    private JokeClient jokeClient;

    @Autowired
    private JokeTellerMapper jokeTellerMapper;

    @Autowired
    private JokeTellerService jokeTellerService;

    @GetMapping
    public JokeTellerDTO getJokeForPerson(@RequestParam("firstName") String name, @RequestParam("lastName") int age){
        LOGGER.info("Started method getPercentage in LoveCalculatorController.");
        LOGGER.info("Getting matching results for names "  + name + " and " + age +".");
        LOGGER.info("Ended method getPercentage in LoveCalculatorController.");

        return jokeClient.getJoke(name, age);
    }


}
