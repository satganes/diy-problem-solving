package com.interview.technical.random;

public class BalloonBurst
{
    public static void permute(int[] arr)
    {
        permuteHelper(arr, 0);
    }

    private static void permuteHelper(int[] arr, int index)
    {
        if (index >= arr.length - 1)
        {
            System.out.print("[");
            for (int i = 0; i < arr.length - 1; i++)
            {
                System.out.print(arr[i] + ", ");
            }
            if (arr.length > 0) System.out.print(arr[arr.length - 1]);
            System.out.println("]");
            return;
        }

        for (int i = index; i < arr.length; i++)
        { // For each index in the sub array arr[index...end]

            // Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            // Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index + 1);

            // Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static int maxCoins(int[] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
        {
            for (int left = 0; left < n - k; ++left)
            {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }
        }

        return dp[0][n - 1];
    }

    public static int maxCoins1(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++)
        {
            for (int start = 0; start <= nums.length - len; start++)
            {
                int end = start + len - 1;
                for (int i = start; i <= end; i++)
                {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                    coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    private static int getValue(int[] nums, int i)
    { // Deal with num[-1] and num[num.length]
        if (i < 0 || i >= nums.length)
        {
            return 1;
        }
        return nums[i];
    }

    public static void main(String[] args)
    {
        permute(new int[] { 1, 2, 3, 4,5,6,7,8,9,10 });
        System.out.println(maxCoins1(new int[] { 1, 2, 3, 4 }));
    }

}
