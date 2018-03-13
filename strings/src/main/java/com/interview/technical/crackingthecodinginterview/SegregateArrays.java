package com.interview.technical.crackingthecodinginterview;

import java.util.Arrays;

/**
 * 1. You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right
 * side of the array. Traverse array only once.
 * 
 * <pre>
 * Example:
 * 
 * Input array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0].<br>
 * Output array = [0, 0, 0, 0, 0,1, 1, 1, 1, 1]
 * </pre>
 * 
 * 2. Given an array A[], write a function that segregates even and odd numbers. The functions
 * should put all even numbers first, and then odd numbers.
 * 
 * <pre>
 * Example:
 * 
 * Input = {12, 34, 45, 9, 8, 90, 3}<br>
 * Output = {12, 34, 8, 90, 45, 9, 3}
 * </pre>
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/">Segregate
 *      Zero's & One's</a> <br>
 * 
 * @see <a hred="https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/"> Segregate Even And
 *      Odd Nos.</a>
 * 
 * 
 * @author Sathish Ganesan
 *
 */
public class SegregateArrays
{
    public static void optimalBinary(int[] input)
    {
        int front = 0, rear = input.length - 1;
        while (front < rear)
        {
            while (input[rear] == 1 && front < rear)
            {
                rear--;
            }
            while (input[front] == 0 && front < rear)
            {
                front++;
            }
            if (front < rear)
            {
                int temp = input[front];
                input[front] = input[rear];
                input[rear] = temp;
                front++;
                rear--;
            }
        }
        System.out.println(Arrays.toString(input));
    }

    public static void optimalOddEven(int[] input)
    {
        int front = 0, rear = input.length - 1;
        while (front < rear)
        {
            while (input[rear] % 2 == 1 && front < rear)
            {
                rear--;
            }
            while (input[front] % 2 == 0 && front < rear)
            {
                front++;
            }
            if (front < rear)
            {
                int temp = input[front];
                input[front] = input[rear];
                input[rear] = temp;
                front++;
                rear--;
            }
        }
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args)
    {
        int[] input = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        SegregateArrays.optimalBinary(input);
        int[] input1 = { 12, 34, 45, 9, 8, 90, 3 };
        SegregateArrays.optimalOddEven(input1);
    }
}
