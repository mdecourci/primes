package com.company.example.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public class AlgorithmsTest {

    private Algorithms algorithms = new Algorithms();

    @Test
    public void primesByEratosthenesSieve() {
        List<Integer> primes = algorithms.primesByEratosthenesSieve(10);
        assertThat(primes).containsExactly(1, 2, 3, 5, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void primesByEratosthenesSieveNegativeUpperBound() {
        algorithms.primesByEratosthenesSieve(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void primesByEratosthenesSieveZeroUpperBound() {
        algorithms.primesByEratosthenesSieve(0);
    }

    @Test
    public void primesByEratosthenesSieveValueOneEdgeCase() {
        List<Integer> primes = algorithms.primesByEratosthenesSieve(1);
        assertThat(primes).containsExactly(1);
    }

    @Test
    public void primesByEratosthenesSieveValueTwoEdgeCase() {
        List<Integer> primes = algorithms.primesByEratosthenesSieve(2);
        assertThat(primes).containsExactly(1);
    }

    @Test
    public void primesByEratosthenesSieveValueThreeEdgeCase() {
        List<Integer> primes = algorithms.primesByEratosthenesSieve(3);
        assertThat(primes).containsExactly(1, 2);
    }

    @Test
    public void primesByEratosthenesSieveValueFourEdgeCase() {
        List<Integer> primes = algorithms.primesByEratosthenesSieve(4);
        assertThat(primes).containsExactly(1, 2, 3);
    }
}