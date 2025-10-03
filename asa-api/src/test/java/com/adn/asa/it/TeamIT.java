package com.adn.asa.it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adn.asa.entity.Team;
import com.adn.asa.it.utils.RestAssuredAbstractIT;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

class TeamIT extends RestAssuredAbstractIT {

    @Test
    void shouldReturnTeam3() {
        Team team = RestAssuredMockMvc.given()
                .when().get("/team/most-popular")
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Team.class);
        
        assertEquals(3, team.getId());
        assertEquals("The Incredibles", team.getName());
        assertEquals(15, team.getCoefficient());
    }
}