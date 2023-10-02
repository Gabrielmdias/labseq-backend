package com.dellent.labseq.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LabSeqServiceTest {

    private LabSeqService classUnderTest;

    @BeforeEach
    public void init() {
        classUnderTest = new LabSeqService();
    }

    @Test
    void calcLabSeqBasicsCases() {
        /* Execution */
        BigInteger result0 = classUnderTest.calcLabSeq(new BigInteger("0"));
        BigInteger result1 = classUnderTest.calcLabSeq(new BigInteger("1"));
        BigInteger result2 = classUnderTest.calcLabSeq(new BigInteger("2"));
        BigInteger result3 = classUnderTest.calcLabSeq(new BigInteger("3"));

        /* Validation */
        assertEquals(result0, new BigInteger("0"));
        assertEquals(result1, new BigInteger("1"));
        assertEquals(result2, new BigInteger("0"));
        assertEquals(result3, new BigInteger("1"));
    }


    @Test
    void calcLabSeq() {
        /* Preparation */
        BigInteger result1 = classUnderTest.calcLabSeq(new BigInteger("16"));
        BigInteger result2 = classUnderTest.calcLabSeq(new BigInteger("17"));

        /* Validation */
        assertEquals(result1.add(result2), classUnderTest.calcLabSeq(new BigInteger("20")));
    }

    @Test
    void calcLabSeqException() {
        /* Validation */
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> classUnderTest.calcLabSeq(new BigInteger("-1")));

        assertEquals("Value cannot be negative.", thrown.getMessage());
    }
}