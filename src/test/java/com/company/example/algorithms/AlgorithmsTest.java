package com.company.example.algorithms;

import com.company.example.algorithms.types.EratosthenesSieve;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public class AlgorithmsTest {

    private EratosthenesSieve primeNumberAlgorithm = new EratosthenesSieve();
    private Algorithms algorithms = new Algorithms();

    @Test
    public void primeNumbers() throws Exception {
        List<Integer> primes = primeNumberAlgorithm.calculate(10);

        algorithms.register(primeNumberAlgorithm);

        List<Integer> primesFromAlgorithms = algorithms.primeNumbers(primeNumberAlgorithm.getType(), 10);
        assertThat(primesFromAlgorithms).isEqualTo(primes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void algorithmsNotRegistered() throws Exception {
        algorithms.primeNumbers(primeNumberAlgorithm.getType(), 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void algorithmsTypeRequired() throws Exception {
        algorithms.register(primeNumberAlgorithm);
        algorithms.primeNumbers(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void algorithmsNullRegistered() throws Exception {
        algorithms.register(null);
        algorithms.primeNumbers(primeNumberAlgorithm.getType(), 10);
    }
}