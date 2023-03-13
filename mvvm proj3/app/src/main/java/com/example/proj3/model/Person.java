package com.example.proj3.model;

public class Person {
    private String genre;
    private String name;

    public Person(String genre, String name) {
        this.genre = genre;
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
