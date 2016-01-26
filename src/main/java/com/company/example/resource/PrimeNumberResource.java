package com.company.example.resource;

import com.company.example.model.Algorithms;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@Named
@Path("/primes")
public class PrimeNumberResource {

    @Inject
    private Algorithms algorithms;

    @POST
    @Path("/calculate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(Integer upper) {
        return Response.ok(algorithms.primesByEratosthenesSieve(upper)).build();
    }
}
