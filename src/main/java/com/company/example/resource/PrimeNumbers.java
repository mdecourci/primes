package com.company.example.resource;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by michaeldecourci on 25/01/2016.
 */
@XmlRootElement
public class PrimeNumbers {
    private int iterations;
    private List<Long> primes;

    public int getIterations() {
        return iterations;
    }

    public PrimeNumbers setIterations(final int pIterations) {
        iterations = pIterations;
        return this;
    }

    public List<Long> getPrimes() {
        return primes;
    }

    public PrimeNumbers setPrimes(final List<Long> pPrimes) {
        primes = pPrimes;
        return this;
    }
}
