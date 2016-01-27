package com.company.example.algorithms;

import com.company.example.algorithms.types.AlgorithmType;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public interface Algorithm<T, R> {
    AlgorithmType getType();
    R calculate(T input);
}
