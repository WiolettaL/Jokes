package com.wostasz.jokes.client;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JokeValue {

    private int id;

    private String joke;

    private String[] categories;

}
