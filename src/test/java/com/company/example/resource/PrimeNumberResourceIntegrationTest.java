package com.company.example.resource;

import com.company.example.Application;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class PrimeNumberResourceIntegrationTest {

    @Test
    public void health() throws JsonProcessingException {

        WebTarget target = ClientBuilder.newClient().target("http://localhost:9000/health");

        Response response = target.request(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("{\"status\":\"UP\"}");
    }

    @Test
    public void calculate() throws JsonProcessingException {

        WebTarget target = ClientBuilder.newClient().target("http://localhost:9000/primes/calculate");

        Response response = target.request(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(Integer.valueOf(10), javax.ws.rs.core.MediaType.TEXT_PLAIN_TYPE));

        assertThat(response.getStatus()).isEqualTo(200);
        List<Long> primeNumbers = response.readEntity(new GenericType<List<Long>>(){});
        assertThat(primeNumbers.size()).isEqualTo(2);
    }
}