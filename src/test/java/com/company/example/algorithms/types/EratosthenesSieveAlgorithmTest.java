package com.company.example.algorithms.types;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public class EratosthenesSieveAlgorithmTest {

    private EratosthenesSieve instance = new EratosthenesSieve();
    
    @Test
    public void getType() throws Exception {
        assertThat(instance.getType()).isEqualTo(AlgorithmType.PRIME_BY_ERATOSTHENES_SIEVE);
    }

    @Test
    public void calculate() {
        List<Integer> primes = instance.calculate(10);
        assertThat(primes).containsExactly(2, 3, 5, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateNegativeUpperBound() {
        instance.calculate(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateZeroUpperBound() {
        instance.calculate(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateValueOneEdgeCase() {
        instance.calculate(1);
    }

    @Test
    public void calculateValueTwoEdgeCase() {
        List<Integer> primes = instance.calculate(2);
        assertThat(primes).containsExactly(2);
    }

    @Test
    public void calculateValueThreeEdgeCase() {
        List<Integer> primes = instance.calculate(3);
        assertThat(primes).containsExactly(2, 3);
    }

    @Test
    public void calculateValueFourEdgeCase() {
        List<Integer> primes = instance.calculate(4);
        assertThat(primes).containsExactly(2, 3);
    }
}