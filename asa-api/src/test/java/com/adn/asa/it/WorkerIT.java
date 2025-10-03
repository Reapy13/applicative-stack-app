package com.adn.asa.it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adn.asa.entity.Worker;
import com.adn.asa.it.utils.RestAssuredAbstractIT;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

class WorkerIT extends RestAssuredAbstractIT {

    @Test
    void shouldReturnAllWorker() {
        Worker[] workers = RestAssuredMockMvc.given()
                .when().get("/worker")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Worker[].class);

        assertEquals(5, workers.length);

        assertEquals(1, workers[0].getId());
        assertEquals("0-Xb4O", workers[0].getName());
        assertEquals(1000, workers[0].getPopularity());

        assertEquals(2, workers[1].getId());
        assertEquals("Adèle", workers[1].getName());
        assertEquals(10, workers[1].getPopularity());

        assertEquals(3, workers[2].getId());
        assertEquals("Basile", workers[2].getName());
        assertEquals(20, workers[2].getPopularity());

        assertEquals(4, workers[3].getId());
        assertEquals("Clément", workers[3].getName());
        assertEquals(30, workers[3].getPopularity());

        assertEquals(5, workers[4].getId());
        assertEquals("Dominique", workers[4].getName());
        assertEquals(150, workers[4].getPopularity());
    }

    @Test
    void shouldReturnFirstWorker() {
        Worker[] workers = RestAssuredMockMvc.given()
                .when().get("/worker?teamId=2")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Worker[].class);

        assertEquals(1, workers.length);

        assertEquals(1, workers[0].getId());
        assertEquals("0-Xb4O", workers[0].getName());
        assertEquals(1000, workers[0].getPopularity());
    }
    
}
