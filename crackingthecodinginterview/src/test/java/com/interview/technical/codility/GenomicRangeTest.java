package com.interview.technical.codility;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GenomicRangeTest
{

    @Test
    public void testCases()
    {
        String S = "CAGCCTA";
        int[] P = { 2, 5, 0 };
        int[] Q = { 4, 5, 6 };
        int[] expected = { 2, 4, 1 };
        assertArrayEquals(expected, GenomicRange.solution(S, P, Q));
    }
}
