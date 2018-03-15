package com.interview.technical.crackingthecodinginterview.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structures?
 *
 */
public class UniqueCharactersInAString
{
    public static void bruteForce(String input)
    {
        char[] sequence = input.toCharArray();
        List<Character> duplicates = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++)
        {
            for (int j = i + 1; j < sequence.length; j++)
            {
                if (sequence[i] == sequence[j])
                {
                    duplicates.add(sequence[i]);
                }
            }
        }
        if (!duplicates.isEmpty())
        {
            System.out.println("Found duplicates: " + duplicates.toString());
        }
        else
        {
            System.out.println("Unique");
        }
    }

    public static void main(String[] args)
    {
        UniqueCharactersInAString.bruteForce("abcd");
    }
}
