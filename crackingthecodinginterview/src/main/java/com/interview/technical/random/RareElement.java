package com.interview.technical.random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

//The problem: presented with an integer array, write a method that will find the nth rarest element in the array.  For example, consider an integer array [3, 2, 3, 2, 3, 1].  The second rarest element in the array is 2 as it occurs just twice.
public class RareElement
{

    private static int findNthRarest(int[] input, int n)
    {
        Map<Integer, Integer> counted = new HashMap<>();
        for (int i : input)
        {
            if (counted.containsKey(i))
            {
                counted.put(i, counted.get(i) + 1);
            }
            else
            {
                counted.put(i, 1);
            }
        }
        Map<Integer, Integer> sortedMap = counted.entrySet()
                .stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        List<Integer> occurrences = sortedMap.entrySet()
                .stream()
                .map(Entry::getValue)
                .distinct()
                .collect(Collectors.toList());
        Optional<Integer> answer = sortedMap.entrySet()
                .stream()
                .map(Entry::getValue)
                .filter(v -> v.intValue() == occurrences.get(n - 1))
                .findFirst();
        return answer.get();
    }

    public static int nthMostRare(int[] elements, int n)
    {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (int i : elements)
        {

            if (countMap.containsKey(i))
            {
                countMap.put(i, countMap.get(i) + 1);
            }
            else
            {
                countMap.put(i, 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comp = Comparator.comparing(entry -> entry.getValue());
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<Map.Entry<Integer, Integer>>(countMap.entrySet());

        sortedList.sort(comp);
        
        sortedList.stream().forEach(System.out::println);
        
        if (n > sortedList.size() - 1) return sortedList.get(sortedList.size() - 1)
                .getKey();
        return sortedList.get(n - 1)
                .getKey();
    }

    public static void main(String[] args)
    {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1,10, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);

        x = findNthRarest(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}
