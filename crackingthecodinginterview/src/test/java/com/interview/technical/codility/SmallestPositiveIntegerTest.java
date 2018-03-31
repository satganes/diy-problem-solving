package com.interview.technical.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallestPositiveIntegerTest
{

    @Test
    public void onlyNegative()
    {
        int[] negative = { -1, -3 };
        assertEquals(1, SmallestPositiveInteger.solution(negative));
        int[] positive1 = { 1, 4, 3 };
        assertEquals(2, SmallestPositiveInteger.solution(positive1));
        int[] positive = { 1, 2, 3 };
        assertEquals(4, SmallestPositiveInteger.solution(positive));
        int[] empty = {};
        assertEquals(1, SmallestPositiveInteger.solution(empty));
        int[] allInt = { -1, -3, 1, 2, 3 };
        assertEquals(4, SmallestPositiveInteger.solution(allInt));
    }

}
