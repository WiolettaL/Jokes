package com.wostasz.jokes.client;

import org.springframework.stereotype.Component;

@Component
public class JokeValue {

    private int id;
    private String joke;
    private String[] categories;

    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
