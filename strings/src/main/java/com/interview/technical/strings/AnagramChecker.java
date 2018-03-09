package com.interview.technical.strings;

import java.util.Arrays;

/**
 * 
 * Given two strings, write a method to decide if one is a permutation of the other.
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/">
 *      Anagrams or not</a>
 * 
 * @author Sathish Ganesan
 *
 */
public class AnagramChecker
{
    public static void bruteForce(String s1, String s2)
    {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        System.out.println(String.valueOf(ch1) + "=" + String.valueOf(ch2));
        if (String.valueOf(ch1)
                .equals(String.valueOf(ch2)))
        {
            System.out.println("The words are Anagrams");
        }
        else
        {
            System.out.println("Not anagram");
        }
    }

    public static boolean optimized(String s1, String s2)
    {
        int[] count = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < s1.length() && i < s2.length(); i++)
        {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i : count)
        {
            if (i != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        AnagramChecker.bruteForce("sathish", "athishs");
        System.out.println(AnagramChecker.optimized("sathisg", "athishs"));
    }

}
