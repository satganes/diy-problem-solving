package com.interview.technical.crackingthecodinginterview.arrays;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 * 
 * @author Sathish Ganesan
 *
 */
public class StringCompression
{
    public static void compress(String input)
    {
        int staticIdx = 0, movingIdx = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        while (staticIdx < input.length() && movingIdx < input.length())
        {
            if (input.charAt(staticIdx) == input.charAt(movingIdx))
            {
                count++;
                movingIdx++;
            }
            else if (input.charAt(staticIdx) != input.charAt(movingIdx))
            {
                result.append(input.charAt(staticIdx));
                result.append(count);
                staticIdx = movingIdx;
                movingIdx++;
                count = 1;
            }
        }
        result.append(input.charAt(staticIdx));
        result.append(count);

        if (result.length() > input.length())
        {
            System.out.println(input);
        }
        else
        {
            System.out.println(result.toString());
        }
    }

    public static void main(String[] args)
    {
        StringCompression.compress("aabcccccaaa");
    }
}
