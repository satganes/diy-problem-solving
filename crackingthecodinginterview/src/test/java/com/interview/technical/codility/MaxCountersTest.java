package com.interview.technical.codility;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MaxCountersTest
{

    int[] input  = { 3, 4, 4, 6, 1, 4, 4 };

    int[] output = { 3, 2, 2, 4, 2 };

    @Test
    public void testCases()
    {
        int[] actual = MaxCounters.solution(5, input);
        assertArrayEquals(output, actual);
    }
}
