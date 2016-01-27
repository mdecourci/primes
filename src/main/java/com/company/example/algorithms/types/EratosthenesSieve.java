package com.company.example.algorithms.types;

import com.company.example.algorithms.AbstractAlgorithm;
import org.springframework.context.annotation.DependsOn;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.company.example.Validations.require;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
@Named
@DependsOn("algorithms")
public class EratosthenesSieve extends AbstractAlgorithm<Integer, List<Integer>> {

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.PRIME_BY_ERATOSTHENES_SIEVE;
    }

    @Override
    public List<Integer> calculate(final Integer upperBound) {
        require(upperBound > 1, "Upper bound must be greater than one");

        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        boolean[] isComposite = new boolean[upperBound + 1];

        for (int i = 2; i <= upperBoundSquareRoot; i++) {
            if (!isComposite[i])  {
                System.out.print(i + " ");
                for (int j = i*i; j <= upperBound; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // output list of notMarked
        List<Integer> primes = new ArrayList<>();
        IntStream.rangeClosed(2, upperBound).filter(i -> (!isComposite[i])).forEach(primes::add);

        return primes;
    }
}
