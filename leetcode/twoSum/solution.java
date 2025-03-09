package java.leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // sabiranje dva niza koriscenjem brute-force
    public static int[] twoSum1(int[] nums, int target) {
        for (var i = 0; i < nums.length - 1; i++) {
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // 2sum problem, kada je niz sortiran. Koristi se greedy pristup
    // koriste se dva pokazivaca, i indeks krece od jedinice
    /*
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return numbers;
        }
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int total = numbers[l] + numbers[r];
            if (total == target) {
                return new int[] { l + 1, r + 1 };
            }
            if (total < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {};
    }

    // drugi nacin, koristeci hashMap pristup
    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers.length == 0) {
            return numbers;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < numbers.length; i++) {
            int total = target - numbers[i];
            if (map.containsKey(total)) {
                return new int[] { map.getOrDefault(total, 1) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return new int[] {};
    }

    // treci nacin
    public int[] twoSum3(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[] { i, map.get(target - num) };
            }
            map.put(num, i);
        }
        return new int[] {};
    }

    // cetvrti nacin
    public int[] twoSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            int total = target - nums[i];
            if (map.containsKey(total)) {
                return new int[] { i, map.get(total) };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
