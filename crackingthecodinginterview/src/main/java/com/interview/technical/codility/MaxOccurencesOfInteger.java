package com.interview.technical.codility;

public class MaxOccurencesOfInteger
{
    static int solution(int M, int[] A)
    {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = -1;

        for (int i = 0; i < N; i++)
        {
            if (count[A[i]] > 0)
            {
                int tmp = count[A[i]];
                if (tmp > maxOccurence)
                {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp + 1;index=i;
            }
            else
            {
                count[A[i]] = 1;index = i;
                // index = i;
            }
        }
        return A[index];
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 3, 1, 3, 1 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A));
        int[] A1 = { 1, 2, 2, 3, 3, 1, 1 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A1));
        int[] A2 = { 0, 0, 0, 0, 1, 2, 2, 3, 3, 1, 1 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A2));
        int[] A3 = { 0, 0 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A3));
        int[] A4 = { 3 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A4));
        int[] A5 = { 3,2 };
        System.out.println(MaxOccurencesOfInteger.solution(3, A5));
        // int[] A4 = {};
        // System.out.println(MaxOccurencesOfInteger.solution(3, A4));
    }
}
