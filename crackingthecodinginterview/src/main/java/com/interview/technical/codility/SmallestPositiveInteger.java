package com.interview.technical.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * @author Sathish Ganesan
 *
 */
public class SmallestPositiveInteger
{
    public static int solution(int[] A)
    {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i : A)
        {
            if (i > 0)
            {
                result.put(i, 1);
            }
        }
        int positive = 1;
        for (int j = 1; j <= result.keySet().size(); j++)
        {
            if (result.get(j) == null)
            {
                positive = j;
                break;
            }
            positive = j+1;
        }
        return positive;
    }

    public static void main(String[] args)
    {
        int[] negative = { -1, -3 };
        System.out.println(SmallestPositiveInteger.solution(negative));
        int[] positive = { 1, 2, 3 };
        System.out.println(SmallestPositiveInteger.solution(positive));
        int[] positive1 = { 1, 4, 3 };
        System.out.println(SmallestPositiveInteger.solution(positive1));
        int[] empty = {};
        System.out.println(SmallestPositiveInteger.solution(empty));
        int[] allInt = { -1, -3, 1, 2, 3 };
        System.out.println(SmallestPositiveInteger.solution(allInt));
    }

}
