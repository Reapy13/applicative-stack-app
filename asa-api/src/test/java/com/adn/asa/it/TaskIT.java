package com.adn.asa.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.adn.asa.entity.Task;
import com.adn.asa.it.utils.RestAssuredAbstractIT;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

class TaskIT extends RestAssuredAbstractIT {

    @Test
    void shouldReturnAllTask() {
        Task[] tasks = RestAssuredMockMvc.given()
                .when().get("/task")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Task[].class);

        assertEquals(2, tasks.length);
        assertEquals(1, tasks[0].getId());
        assertEquals("Se laver", tasks[0].getTitle());
        assertTrue(tasks[0].isCompleted());
        assertEquals(2, tasks[1].getId());
        assertEquals("Aller au travail", tasks[1].getTitle());
        assertFalse(tasks[1].isCompleted());
    }

    @Test
    void shouldReturnSecondTask() {
        Task[] tasks = RestAssuredMockMvc.given()
                .when().get("/task?workerId=2")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Task[].class);

        assertEquals(1, tasks.length);
        assertEquals(2, tasks[0].getId());
        assertEquals("Aller au travail", tasks[0].getTitle());
        assertFalse(tasks[0].isCompleted());
    }
    
}
