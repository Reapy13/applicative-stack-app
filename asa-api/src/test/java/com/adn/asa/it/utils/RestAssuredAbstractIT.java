package com.adn.asa.it.utils;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.adn.asa.Application;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.parsing.Parser;

@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public abstract class RestAssuredAbstractIT {

    @LocalServerPort
    private int port;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
        RestAssuredMockMvc.mockMvc(mockMvc);
    }
}