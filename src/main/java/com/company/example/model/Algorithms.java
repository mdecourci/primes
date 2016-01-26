package com.company.example.model;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.company.example.model.Validations.require;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
@Named
public class Algorithms {

    public List<Integer> primesByEratosthenesSieve(int upperBound) {
        require(upperBound > 0, "Upper bound must be positive");
	/*
     * assume all integers less than upperBound
	 * to be prime by default initializing
	 * corresponding notMarked array to false
	 *
	 */
        boolean[] notMarked = new boolean[upperBound];

	/*
	 * mark all multiples starting with 2
	 */
        for (int i = 2; i*i < upperBound; i++)
            for (int j = 2; j * i < upperBound; j++)
                if (!notMarked[j * i])
                    notMarked[j * i] = true;

        // output list of notMarked
        List<Integer> primes = new ArrayList<>();
        primes.add(1);
        IntStream.range(2, upperBound).filter(i -> (!notMarked[i])).forEach(primes::add);

        return primes;
    }
}
