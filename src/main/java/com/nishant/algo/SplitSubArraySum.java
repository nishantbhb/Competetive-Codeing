package com.nishant.algo;


/**
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitSubArraySum {

    public int splitArray(int[] nums, int m) {
        if (nums.length < 2)
            return nums[0];

        long low = 0;//maximum number in array
        long high = 0;//sum of all the numbers in array

        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        if (m == 1)
            return (int) high;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (isValid(mid, nums, m))
                high = mid;//the value is too large to form 'm' sub-arrays
            else
                low = mid + 1;//the value is too small to split into exactly 'm' sub-arrays
        }

        //the exact sum
        return (int) low;

    }

    private boolean isValid(long target, int[] nums, int m) {
        int cnt = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                cnt++;
                sum = num;
                if (cnt > m)
                    return false;//the count of sub-arrays exceeded max 'm'
            }
        }
        return true;//the count of sub-arrays <= 'm'
    }


}
