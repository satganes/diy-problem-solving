package com.interview.technical.crackingthecodinginterview.arrays;

/**
 * We are given an array (or string), the task is to reverse the array.
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/">Reverse an
 *      Array or String</a>
 * 
 * @author Sathish Ganesan
 *
 */
public class StringReversals
{
    public static void charReverse(String input)
    {
        char[] ch = input.toCharArray();
        int startIdx = 0, endIdx = ch.length - 1;
        char temp;
        while (startIdx < endIdx)
        {
            temp = ch[startIdx];
            ch[startIdx] = ch[endIdx];
            ch[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
        System.out.println(String.valueOf(ch));
    }

    /**
     * 
     * Reverse the sentence without reversing the characters in the string.
     * 
     * <pre>
     * Example: 
     * I am Sathish
     * 
     * Sathish am I
     * </pre>
     * 
     * @param input
     */
    public static void sentenceReverse(String input)
    {
        String[] sequence = input.split("\\s");
        StringBuilder builder = new StringBuilder();
        for (int i = sequence.length - 1; i >= 0; i--)
        {
            builder.append(sequence[i]);
            builder.append(" ");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args)
    {
        StringReversals.charReverse("Sathish");
        StringReversals.sentenceReverse("I am Sathish");
    }
}
