package com.interview.technical.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array of integers, print the array in such a way that the first element is first maximum
 * and second element is first minimum and so on.
 * 
 * <pre>
 * Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
 * Output : 7 1 6 2 5 3 4
 * Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
 * Output : 9 1 8 2 7 3 6 4
 * </pre>
 * 
 * @see <a href="https://www.geeksforgeeks.org/alternative-sorting/"> Alternative Sorting</a>
 * 
 * @author Sathish Ganesan
 *
 */
public class AlternativeSorting
{
    public static void sort(int[] input)
    {
        Arrays.sort(input);
        int start = 0, end = input.length - 1;

        List<Integer> temp = new ArrayList<>();
        while (start < end)
        {
            temp.add(input[end]);
            temp.add(input[start]);
            start++;
            end--;
        }
        if (input.length % 2 != 0)
        {
            temp.add(input[end]);
        }
        System.out.println(temp.toString());
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        AlternativeSorting.sort(input);
    }

}
