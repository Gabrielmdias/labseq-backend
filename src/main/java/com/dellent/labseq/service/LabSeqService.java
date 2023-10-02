package com.dellent.labseq.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LabSeqService {

    private final Map<BigInteger, BigInteger> cache = new HashMap<>();

    public BigInteger calcLabSeq(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }

        /* Check if the value is cached */
        if (cache.containsKey(value)) {
            return cache.get(value);
        }

        /* Basic cases */
        Optional<BigInteger> baseCase = getBaseCase(value);
        if (baseCase.isPresent()) {
            return baseCase.get();
        }

        /* Calculate value */
        BigInteger result = calcLabSeq(value.subtract(BigInteger.valueOf(4)))
                .add(calcLabSeq(value.subtract(BigInteger.valueOf(3))));

        cache.put(value, result);

        return result;
    }

    private Optional<BigInteger> getBaseCase(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) == 0 || value.compareTo(BigInteger.TWO) == 0){
            return Optional.of(BigInteger.ZERO);
        } else if (value.compareTo(BigInteger.ONE) == 0 || value.compareTo(BigInteger.valueOf(3)) == 0) {
            return Optional.of(BigInteger.ONE);
        } else {
            return Optional.empty();
        }
    }
}
