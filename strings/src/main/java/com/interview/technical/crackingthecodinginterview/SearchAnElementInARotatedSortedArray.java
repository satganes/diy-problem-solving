package com.interview.technical.crackingthecodinginterview;

/**
 * 
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose we
 * rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance,
 * 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log
 * n) time.
 * 
 * <pre>
 * Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 3; Output : Found at index 8
 * 
 * Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 30; Output : Not found
 * 
 * Input : arr[] = {30, 40, 50, 10, 20}; key = 10; Output : Found at index 3
 * 
 * </pre>
 * 
 * @see <a href= "https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/">
 *      Search an element in a sorted & rotated array </a>
 * 
 * @author Sathish Ganesan
 *
 */
public class SearchAnElementInARotatedSortedArray
{
    public static void optimal(int[] input, int key)
    {
        int pivot = findPivot(input, 0, input.length);

        if (key == input[pivot])
        {
            System.out.println("Found at index: " + pivot);
        }
        else if (input[0] <= key)
        {
            System.out.println("Found at index: " + binarySearch(input, 0, pivot - 1, key));
        }
        else
        {
            System.out.println("Found at index: " + binarySearch(input, pivot + 1, input.length - 1, key));
        }
    }

    private static int binarySearch(int[] input, int low, int high, int key)
    {
        int mid = (low + high) / 2;
        if (key == input[mid])
        {
            return mid;
        }
        else if (input[mid] < key)
        {
            return binarySearch(input, (mid + 1), high, key);
        }
        return binarySearch(input, low, (mid - 1), key);
    }

    private static int findPivot(int[] input, int low, int high)
    {
        int mid = (low + high) / 2;

        if (input[mid] > input[mid + 1])
        {
            return mid;
        }
        else if (input[mid] < input[mid - 1])
        {
            return (mid - 1);
        }
        else if (input[low] > input[mid])
        {
            return findPivot(input, low, mid - 1);
        }
        return findPivot(input, mid + 1, high);
    }

    public static void main(String[] args)
    {
        int[] input = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
        SearchAnElementInARotatedSortedArray.optimal(input, 5);
        int[] input1 = { 5, 6, 1, 2, 3, 4 };
        SearchAnElementInARotatedSortedArray.optimal(input1, 6);

    }
}
