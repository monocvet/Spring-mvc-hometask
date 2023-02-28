package ru.maxima.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.maxima.springmvc.models.Book;
import ru.maxima.springmvc.models.Person;

import java.util.*;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).
                stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person(name, age) values(?, ?)", person.getName(),
                person.getAge());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("update person set name = ? , age = ? where id = ?", updatedPerson.getName(),
                updatedPerson.getAge(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id = ?", id);
    }


    public List<Book> findUserBooks(int person_id) {
        return jdbcTemplate.query("select * from book where person_id = ?",new Object[]{person_id},new BeanPropertyRowMapper<>(Book.class));
    }
}