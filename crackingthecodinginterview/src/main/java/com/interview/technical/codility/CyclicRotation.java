package com.interview.technical.codility;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is moved to the first place. For example, the rotation
 * of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right
 * by one index and 6 is moved to the first place).
 * 
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); }
 * 
 * that, given a zero-indexed array A consisting of N integers and an integer K,
 * returns the array A rotated K times.
 * 
 * For example, given
 * 
 * A = [3, 8, 9, 7, 6] K = 3 the function should return [9, 7, 6, 3, 8]. Three
 * rotations were made:
 * 
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] [7, 6,
 * 3, 8, 9] -> [9, 7, 6, 3, 8] For another example, given
 * 
 * A = [0, 0, 0] K = 1 the function should return [0, 0, 0]
 * 
 * Given
 * 
 * A = [1, 2, 3, 4] K = 4 the function should return [1, 2, 3, 4]
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [−1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 * 
 * @author Sathish Ganesan
 *
 */
public class CyclicRotation
{
    public static int[] solution(int[] A, int K)
    {
        if (K > 0 && A.length > 0 && A.length < K)
        {
            K = K % A.length;
        }
        reverse(A, A.length - K, A.length - 1);
        reverse(A, 0, A.length - K - 1);
        reverse(A, 0, A.length - 1);
        return A;
    }

    private static void reverse(int[] input, int startIdx, int endIdx)
    {
        while (startIdx < endIdx)
        {
            int temp = input[startIdx];
            input[startIdx] = input[endIdx];
            input[endIdx] = temp;
            --endIdx;
            ++startIdx;
        }
    }

    public static void main(String[] args)
    {
        int[] input = { 1, 1, 2, 3, 5 };
        System.out.println(Arrays.toString(CyclicRotation.solution(input, 7)));

    }
}
