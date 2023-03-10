package ru.maxima.springmvc.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Book {
    private int id;

    private int personID;

    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 2, max = 150, message = "Name should be between 2 and 150 characters")
    private String name;

    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 2, max = 150, message = "Name should be between 2 and 150 characters")
    private String author;

    @Min(value = 0, message = "Age should be more than 0")
    private int year;

    public Book() {
    }

    public Book(int id, int personID, String name, String author, int year) {
        this.id = id;
        this.personID = personID;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int person_ID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
