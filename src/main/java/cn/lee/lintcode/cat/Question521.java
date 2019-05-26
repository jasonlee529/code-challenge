package cn.lee.lintcode.cat;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description?_from=cat
 */
public class Question521 {

    public int deduplication(int[] nums) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.get(n) == null) {
                map.put(n, 1);
            } else {
                int count = map.get(n);
                if (count > 0) {
                    move(nums, i);
                }
                map.put(n, map.get(n) + 1);
            }
        }
        for (int n : nums) {
            System.out.print("  "+n);
        }
        System.out.println("");
        return 0;
    }

    private void move(int[] nums, int i) {
        int t = nums[i];
        for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j + 1];
        }
        nums[nums.length - 1] = t;
    }

    public static void main(String[] args) {
        Question521 question = new Question521();
        System.out.println(question.deduplication(new int[]{1, 3, 1, 4, 4, 2}));
    }
}
