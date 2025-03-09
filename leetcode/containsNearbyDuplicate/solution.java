package java.leetcode.containsNearbyDuplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solution {

    // Contains Duplicate II
    /*
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // drugi nacin, koriscenjem sliding window
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0;
        Set<Integer> window = new HashSet<>();
        for (var r = 0; r < nums.length; r++) {
            if (r - l > k) {
                window.remove(nums[l]);
                l++;
            }
            if (window.contains(nums[r])) {
                return true;
            }
            window.add(nums[r]);
        }
        return false;
    }
}
