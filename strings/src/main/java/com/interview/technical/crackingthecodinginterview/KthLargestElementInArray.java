package com.interview.technical.crackingthecodinginterview;

import java.util.Arrays;
import java.util.Collections;

/**
 * Write an efficient program for printing k largest elements in an array. Elements in array can be
 * in any order.
 * 
 * For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3
 * elements i.e., k = 3 then your program should print 50, 30 and 23.
 * 
 * <pre>
 * Example Set 1,2,3
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 3 Output: 7
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 4 Output: 10
 * </pre>
 * 
 * @see <a href= "https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/">Kth
 *      Largest Element in an array</a>
 * @see <a href= "https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/">Set
 *      1</a>
 * @see <a href=
 *      "https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time-2/">Set
 *      2</a>
 * @see <a href=
 *      "https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/">Set
 *      3</a>
 * 
 * @author Sathish Ganesan
 *
 */
public class KthLargestElementInArray
{
    public static void getLargestNumber(int[] input, int k)
    {
        Integer[] myInput = Arrays.stream(input)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(myInput, Collections.reverseOrder());

        for (int i = 0; i < k; i++)
        {
            System.out.println(myInput[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 1, 23, 12, 9, 30, 2, 50 };
        KthLargestElementInArray.getLargestNumber(input, 3);
    }
}
