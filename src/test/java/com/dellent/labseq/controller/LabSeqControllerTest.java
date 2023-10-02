package com.dellent.labseq.controller;

import com.dellent.labseq.service.LabSeqService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class LabSeqControllerTest {

    private LabSeqService mockLabSeqService;
    private LabSeqController classUnderTest;

    @BeforeEach
    public void init() {
        mockLabSeqService = Mockito.mock(LabSeqService.class);
        classUnderTest = new LabSeqController(mockLabSeqService);
    }

    @Test
    public void getLabSeq() {
        /* Preparation */
        BigInteger value = new BigInteger("10");
        Mockito.when(mockLabSeqService.calcLabSeq(value)).thenReturn(new BigInteger("3"));

        /* Execution */
        BigInteger result = classUnderTest.getLabSeq(value);

        /* Validation */
        Mockito.verify(mockLabSeqService, Mockito.times(1)).calcLabSeq(value);
        assertEquals(new BigInteger("3"), result);
    }
}