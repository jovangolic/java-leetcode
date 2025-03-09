package java.leetcode.longestConsecutive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class solution {

    // Longest Consecutive Sequence
    /*
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 0;
        /*
         * Set<Integer> set = new HashSet<>();
         * for (var i = 0; i < nums.length; i++) {
         * set.add(nums[i]);
         * }
         */
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        for (int i : set) {
            // proveri ako sekvenca ima pocetak
            if (!set.contains(i - 1)) {
                int len = 1;
                while (set.contains(i + len)) {
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }

    // drugi nacin
    public static int longestConsecutive2(int[] arr) {
        if (arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int ans = 0, count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                continue;
            else if (arr[i] - arr[i - 1] == 1) {
                count += 1;
            } else {
                ans = Math.max(count, ans);
                count = 0;
            }
        }
        ans = Math.max(count, ans);
        ans += 1;
        return ans;
    }
}
