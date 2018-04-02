package com.interview.technical.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DistinctTest
{
    @Test
    public void testDistinct()
    {
        int[] input = { 2, 1, 1, 2, 3, 1 };
        assertEquals(3, Distinct.solution1(input));
    }

}
