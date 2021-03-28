package com.wostasz.jokes.client;

import org.springframework.stereotype.Component;

@Component
public class JokeResponse {

    private String type;
    private JokeValue value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JokeValue getValue() {
        return value;
    }

    public void setValue(JokeValue value) {
        this.value = value;
    }

}

