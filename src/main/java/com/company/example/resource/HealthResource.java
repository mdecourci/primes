package com.company.example.resource;

import org.springframework.boot.actuate.health.Health;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@Named
@Path("/health")
public class HealthResource {
    @GET
    @Produces("application/json")
    public Health health() {
        return Health.up().build();
    }
}
