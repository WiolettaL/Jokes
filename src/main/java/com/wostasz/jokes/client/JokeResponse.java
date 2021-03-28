package com.wostasz.jokes.client;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JokeResponse {

    private String type;

    private JokeValue value;

}

