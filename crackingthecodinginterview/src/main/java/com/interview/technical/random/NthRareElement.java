package com.interview.technical.random;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
 * presented with an integer array, write a method that will find the nth rarest element in the
 * array. For example, consider an integer array [3, 2, 3, 2, 3, 1]. The second rarest element in
 * the array is 2 as it occurs just twice.
 * 
 * @author Sathish Ganesan
 *
 */
public class NthRareElement
{

    public static void main(String[] args)
    {
        int[] input = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5 };
        int n = 2;

        findNthRarest(input, n);
    }

    private static void findNthRarest(int[] input, int n)
    {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int number : input)
        {
            Integer count = countMap.get(number);
            countMap.put(number, (count == null) ? 1 : ++count);
        }
        Map<Integer, Integer> sortedMap = countMap.entrySet()
                .parallelStream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        
        System.out.println(sortedMap);
        

    }

}
