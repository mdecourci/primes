package com.company.example.algorithms;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public abstract class AbstractAlgorithm<T, R> implements Algorithm<T, R> {

    @Inject
    protected Algorithms algorithms;

    @PostConstruct
    public void postConstruct() {
        algorithms.register(this);
    }
}
