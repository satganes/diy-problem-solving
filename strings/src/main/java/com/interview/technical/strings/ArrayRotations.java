package com.interview.technical.strings;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * 
 * <pre>
 * Example:
 * [1, 2, 3, 4, 5, 6, 7]
 *      d=2
 * [3, 4, 5, 6, 7, 1, 2]
 * </pre>
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/">
 *      Array Rotation by Reveral Algorithm </a>
 * @see <a href= "https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/"> Cyclic
 *      Array Rotation</a>
 * 
 * @author Sathish Ganesan
 *
 */
public class ArrayRotations
{
    /**
     * <pre>
     * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7 
     * 1) Store d elements in a temp array 
     *      temp[] = [1,2] 
     * 2) Shift rest of the arr[] 
     *      arr[] = [3, 4, 5, 6, 7, 6, 7] 
     * 3) Store back the d elements 
     *      arr[] = [3, 4, 5, 6, 7, 1, 2]
     * </pre>
     * 
     * @see <a href="https://www.geeksforgeeks.org/array-rotation/">Using temp array</a>
     * @param input[]
     * @param int
     *            - number of elements to be rotated
     */
    public static void rotateUsingTempVariable(int[] input, int d)
    {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++)
        {
            temp[i] = input[i];
        }
        for (int i = d; i < input.length; i++)
        {
            input[i - d] = input[i];
        }
        for (int i = input.length - temp.length, j = 0; i < input.length && j < temp.length; i++, j++)
        {
            input[i] = temp[j];
        }
        System.out.println(Arrays.toString(input));
    }

    /**
     * @param input[]
     * @param d
     */
    public static void rotateByReversalAlgorithm(int[] input, int d)
    {
        reverseTheArray(input, 0, d - 1);
        reverseTheArray(input, d, input.length - 1);
        reverseTheArray(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void reverseTheArray(int[] input, int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 1, 2, 3, 4, 5, 6 };
        ArrayRotations.rotateUsingTempVariable(input, 2);
        int[] reversalInput = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        ArrayRotations.rotateUsingTempVariable(reversalInput, 3);
    }

}
