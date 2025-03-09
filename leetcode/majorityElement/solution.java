package java.leetcode.majorityElement;

import java.util.HashMap;
import java.util.Map;

public class solution {

    // metoda koja trazi majority element
    public static int majorityElement(int[] nums) {
        int majority = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // nakon prvog okretanja imam npr {3:1}, ako je npr ulazni parametar ovo
            // n=[3,2,3]
            map.put(num, 1 + map.getOrDefault(num, 0));
            if (map.get(num) > majority) {
                result = num;
                majority = map.get(num);
            }
        }
        return result;
    }

    // drugi nacin
    public static int majorityElement2(int[] nums) {
        int majority = 0;
        int result = 0;
        for (int num : nums) {
            if (majority == 0) {
                result = num;
            }
            if (num == result) {
                majority += num;
            } else {
                majority -= num;
            }
        }
        return result;
    }
}
