package com.company.example.config;

import com.company.example.resource.HealthResource;
import com.company.example.resource.PrimeNumberResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.context.annotation.Configuration;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@Configuration
//@ApplicationPath("/company")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HealthResource.class);
        register(WadlResource.class);
        register(PrimeNumberResource.class);

        configureSwagger();
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("com.company.example.resource");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }

}
