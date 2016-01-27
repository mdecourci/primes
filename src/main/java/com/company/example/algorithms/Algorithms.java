package com.company.example.algorithms;

import com.company.example.Validations;
import com.company.example.algorithms.types.AlgorithmType;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
@Named
public class Algorithms {

    private Map<AlgorithmType, Algorithm> algorithmRegistry = new HashMap<>();

    public List<Integer>  primeNumbers(final AlgorithmType pAlgorithmType, int pUpperBound) {
        Validations.require(pAlgorithmType != null, "Algorithm type is mandatory");
        Validations.require(algorithmRegistry.containsKey(pAlgorithmType), "Algorithm of type " + pAlgorithmType + " is not registered");

        return (List<Integer>) algorithmRegistry.get(pAlgorithmType).calculate(pUpperBound);
    }

    void register(final Algorithm pAlgorithm) {
        Validations.require(pAlgorithm != null, "Algorithm is mandatory");
        this.algorithmRegistry.put(pAlgorithm.getType(), pAlgorithm);
    }
}
