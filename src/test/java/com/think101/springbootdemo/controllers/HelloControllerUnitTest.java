package com.think101.springbootdemo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerUnitTest {
    @Test
    public void testSayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("Spring", model);
        assertAll(
                () -> assertEquals("hello", result),
                () -> assertEquals("Spring", model.asMap().get("user"))
        );
    }
}
