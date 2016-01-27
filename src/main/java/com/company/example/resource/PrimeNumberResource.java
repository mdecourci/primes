package com.company.example.resource;

import com.company.example.algorithms.types.AlgorithmType;
import com.company.example.algorithms.Algorithms;
import com.company.example.model.PrimeNumberRequest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(PrimeNumberRequest pRequest) {
        return Response.ok(algorithms.primeNumbers(AlgorithmType.valueOf(pRequest.getAlgorithmType()), pRequest.getUpperBound())).build();
    }
}
