package com.think101.springbootdemo.controllers;

import com.think101.springbootdemo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestContollerFunctionalTest {

    @Autowired
    private TestRestTemplate template;


    @Test
    public void greetWithName() {
        Greeting response = template.getForObject("/rest?name=Max", Greeting.class);
        assertEquals("Hello, Max!", response.getMessage());
    }

    @Test
    public void greetWithoutName(@Autowired TestRestTemplate template) {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        assertEquals("Hello, World!", Objects.requireNonNull(entity.getBody()).getMessage());
    }
}
