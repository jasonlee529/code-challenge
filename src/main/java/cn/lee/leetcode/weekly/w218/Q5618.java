package cn.lee.leetcode.weekly.w218;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q5618
 * @Description: https://leetcode-cn.com/contest/weekly-contest-218/problems/max-number-of-k-sum-pairs/
 * @author: libo
 * @date: 2020/12/6 10:34
 * @Version: 1.0
 */
@Slf4j
public class Q5618 {
    @Test
    public void test() {
        Assert.assertEquals(2, maxOperations(new int[]{1, 2, 3, 4}, 5));
        Assert.assertEquals(1, maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        int count = 0;
        for (int n : map.keySet()) {
            int m = k - n;
            if (map2.containsKey(n) || map2.containsKey(m)) {
                continue;
            }
            count += n == m ? map.get(n) / 2 : Math.min(map.get(n), map.getOrDefault(m, 0));
            map2.put(m, 0);
            map2.put(n, 0);
        }
        return count;
    }

    public int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int[] pos = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (pos[i] == 1) {
                continue;
            }
            if (nums[i] >= k) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= k) {
                    break;
                }
                if (pos[j] == 1 || pos[i] == 1) {
                    continue;
                }

                if (nums[i] + nums[j] == k) {
                    pos[i] = 1;
                    pos[j] = 1;
                    count++;
//                    System.out.println(k + " =  " + i + " + " + j);
                }
            }
        }
        return count;
    }
}
