package com.interview.technical.crackingthecodinginterview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 1. Given an array of integers, print the array in such a way that the first element is first
 * maximum and second element is first minimum and so on.
 * 
 * <pre>
 * Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
 * Output : 7 1 6 2 5 3 4
 * Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
 * Output : 9 1 8 2 7 3 6 4
 * </pre>
 * 
 * 2. An array contains both positive and negative numbers in random order. Rearrange the array
 * elements so that positive and negative numbers are placed alternatively. Number of positive and
 * negative numbers need not be equal. If there are more positive numbers they appear at the end of
 * the array. If there are more negative numbers, they too appear in the end of the array.
 * 
 * 
 * <pre>
 * Example:
 * input = [-1, 2, -3, 4, 5, 6, -7, 8, 9]
 * output = [9, -7, 8, -3, 5, -1, 2, 4, 6]
 * </pre>
 * 
 * @see <a href="https://www.geeksforgeeks.org/alternative-sorting/"> Alternative Sorting</a>
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/">Rearrange
 *      +ve & -ve nos. in an array</a>
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

    /**
     * An array contains both positive and negative numbers in random order. Rearrange the array
     * elements so that positive and negative numbers are placed alternatively. Number of positive and
     * negative numbers need not be equal. If there are more positive numbers they appear at the end of
     * the array. If there are more negative numbers, they too appear in the end of the array. *
     * 
     * <pre>
     * Example:
     * input = [-1, 2, -3, 4, 5, 6, -7, 8, 9]
     * output = [9, -7, 8, -3, 5, -1, 2, 4, 6]
     * </pre>
     * 
     * @param input
     */
    public static void sortAllNumbers(int[] input)
    {
        Arrays.sort(input);
        int start = 0, end = input.length - 1;
        System.out.println(Arrays.toString(input));
        List<Integer> temp = new ArrayList<>();
        while (input[start] < 0 && input[end] > 0)
        {
            temp.add(input[end]);
            temp.add(input[start]);
            start++;
            end--;
        }
        if (input.length != temp.size() && input[start] < 0)
        {
            while (input[start] < 0)
            {
                temp.add(input[start]);
                start++;
            }
        }
        else if (input.length != temp.size() && input[end] > 0)
        {
            while (input[end] > 0)
            {
                temp.add(input[end]);
                end--;
            }
        }
        System.out.println(temp.toString());
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        AlternativeSorting.sort(input);
        int[] scrambledInput = new int[] { -1, 2, -3, 4, 5, 6, -7, 8, 9};
        AlternativeSorting.sortAllNumbers(scrambledInput);
    }

}
