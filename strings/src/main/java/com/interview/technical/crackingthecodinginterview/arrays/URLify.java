package com.interview.technical.crackingthecodinginterview.arrays;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you
 * can perform this operation in place.)
 * 
 * <pre>
 * 
 * EXAMPLE 
 * 
 *      Input: "Mr John Smith ", 
 * 
 *      Output: "Mr%20John%20Smith"
 * 
 * </pre>
 * 
 * @author Sathish Ganesan
 *
 */
public class URLify
{
    public static void optimalSolution(String input)
    {
        int length = trim(input);
        int spaces = 0;
        for (int i = 0; i < length; i++)
        {
            if (input.charAt(i) == Character.MIN_VALUE)
            {
                spaces++;
            }
        }
        int fullLength = length + spaces * 2;
        StringBuilder result = new StringBuilder();
        for (int i = fullLength - 1; i > 0; i--)
        {
//            result.append
        }
    }

    private static int trim(String input)
    {
        for (int i = input.length() - 1; i > 0; i--)
        {
            if (input.charAt(i) != Character.MIN_VALUE)
            {
                return i + 1;
            }
        }
        return -1;
    }
}
