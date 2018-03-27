package com.interview.technical.codility;

import java.util.Arrays;

/**
 * 
 * A non-empty zero-indexed array A consisting of N integers is given. Array A
 * represents numbers on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... +
 * A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first
 * part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 * <pre>
 * A[0] = 3 
 * A[1] = 1 
 * A[2] = 2 
 * A[3] = 4 
 * A[4] = 3
 * </pre>
 * 
 * We can split this tape in four places:
 * 
 * <pre>
 * P = 1, difference = |3 − 10| = 7 
 * P = 2, difference = |4 − 9| = 5 
 * P = 3, difference = |6 − 7| = 1 
 * P = 4, difference = |10 − 3| = 7
 * </pre>
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty zero-indexed array A of N integers, returns the
 * minimal difference that can be achieved.
 * 
 * For example, given:
 * 
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return 1, as
 * explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−1,000..1,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * @author Sathish Ganesan
 *
 */
public class TapeEquilibrium
{
    public static int solution1(int[] A)
    {

        long sumright = 0;
        long sumleft = 0;
        long ans;

        for (int i = 1; i < A.length; i++)
            sumright += A[i];

        sumleft = A[0];
        ans = Math.abs(sumleft - sumright);

        for (int P = 1; P < A.length; P++)
        {
            if (Math.abs(sumleft - sumright) < ans)
            {
                ans = Math.abs(sumleft - sumright);
            }
            sumleft += A[P];
            sumright -= A[P];
        }
        return (int) ans;
    }

    public static int solution(int[] A)
    {
        for (int i = 1; i < A.length; i++)
        {
            A[i] += A[i - 1];
        }
        int minDiff = Math.abs(A[0] - ((A[A.length - 1]) - A[0]));
        for (int i = 1; i < A.length; i++)
        {
            if (Math.abs(A[i] - ((A[A.length - 1]) - A[i])) < minDiff)
            {
                minDiff = Math.abs(A[i] - ((A[A.length - 1]) - A[i]));
            }
            ;

        }
        return minDiff;
    }

    public static void main(String[] args)
    {
        int[] input = { -1000, 1000 };
        System.out.println(TapeEquilibrium.solution1(input));
        int[] input1 = { 5, 6, 2, 4, 1 };
        System.out.println(TapeEquilibrium.solution1(input1));
        int[] input2 = { -10, -20, -30, -40, 100 };
        System.out.println(TapeEquilibrium.solution1(input2));
        int[] input3 = { 3, 1, 2, 4, 3 };
        System.out.println(TapeEquilibrium.solution1(input3));
    }
}
