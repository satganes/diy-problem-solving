package com.interview.technical.codility;

import java.util.Arrays;

/**
 * 
 * You are given N counters, initially set to 0, and you have two possible
 * operations on them:
 * 
 * increase(X) − counter X is increased by 1, max counter − all counters are set
 * to the maximum value of any counter. A non-empty zero-indexed array A of M
 * integers is given. This array represents consecutive operations:
 * 
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X), if A[K] =
 * N + 1 then operation K is max counter. For example, given integer N = 5 and
 * array A such that:
 * 
 * <pre>
 * A[0] = 3 
 * A[1] = 4 
 * A[2] = 4 
 * A[3] = 6 
 * A[4] = 1 
 * A[5] = 4 
 * A[6] = 4
 * </pre>
 * 
 * the values of the counters after each consecutive operation will be:
 * 
 * <pre>
 * (0, 0, 1, 0, 0) 
 * (0, 0, 1, 1, 0) 
 * (0, 0, 1, 2, 0) 
 * (2, 2, 2, 2, 2) 
 * (3, 2, 2, 2, 2) 
 * (3, 2, 2, 3, 2) 
 * (3, 2, 2, 4, 2)
 * </pre>
 * 
 * The goal is to calculate the value of every counter after all operations.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int N, int[] A); }
 * 
 * that, given an integer N and a non-empty zero-indexed array A consisting of M
 * integers, returns a sequence of integers representing the values of the
 * counters.
 * 
 * The sequence should be returned as:
 * 
 * a structure Results (in C), or a vector of integers (in C++), or a record
 * Results (in Pascal), or an array of integers (in any other programming
 * language). For example, given:
 * 
 * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4 the function
 * should return [3, 2, 2, 4, 2], as explained above.
 * 
 * Assume that:
 * 
 * N and M are integers within the range [1..100,000]; each element of array A
 * is an integer within the range [1..N + 1]. Complexity:
 * 
 * expected worst-case time complexity is O(N+M); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * @author Sathish Ganesan
 *
 */
public class MaxCounters
{
    public static int[] solution(int N, int[] A)
    {
        int[] counter = new int[N];
        // Arrays.fill(counter, 0);
        int maxCounter = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] == N + 1)
            {
                Arrays.fill(counter, maxCounter);
//                int[] temp = new int[N];
//                System.arraycopy(counter, 0, temp, 0, temp.length);
//                counter = temp;
            }
            else
            {
                ++counter[A[i] - 1];
                if (counter[A[i] - 1] > maxCounter)
                {
                    maxCounter = counter[A[i] - 1];
                }
            }
        }
        return counter;
    }

}
