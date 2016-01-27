package com.company.example.algorithms.types;

import com.company.example.algorithms.AbstractAlgorithm;
import org.springframework.context.annotation.DependsOn;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.company.example.Validations.require;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
@Named
@DependsOn("algorithms")
public class PrimeByRemainder extends AbstractAlgorithm<Integer, List<Integer>> {

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.PRIME_BY_REMAINDER;
    }

    @Override
    public List<Integer> calculate(final Integer n) {
        require(n > 1, "Upper bound must be greater than one");

        int[] numbers = new int[n];
        for (int i = 2; i <= n; i++) {
            numbers[i-1] = i;
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            boolean isPrime = true;
            if (numbers[i] != 2) {

                for (int j = 2; j <= numbers[i]; j++) {
                    if (numbers[i] != j) {
                        if (numbers[i] % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

            }
            if (isPrime) {
                primes.add(numbers[i]);
            } else {
                numbers[i] = 0;
            }
        }
        return primes;
    }
}
