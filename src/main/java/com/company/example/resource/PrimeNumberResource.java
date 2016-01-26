package com.company.example.resource;

import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@Named
@Path("/primes")
public class PrimeNumberResource {

    @POST
    @Path("/calculate")
    //@Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(String iterations) {
        System.out.println("*** calculate() iterations=" + iterations);
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.setIterations(Integer.valueOf(iterations));
        primeNumbers.setPrimes(Arrays.asList(10l, 20l));
//        return Response.ok(primeNumbers).build();
        return Response.ok(Arrays.asList(10l, 20l)).build();
    }
}
