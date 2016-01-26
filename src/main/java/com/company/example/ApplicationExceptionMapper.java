package com.company.example;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@Provider
public class ApplicationExceptionMapper implements ExceptionMapper {
    @Override
    public Response toResponse(final Throwable pThrowable) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
