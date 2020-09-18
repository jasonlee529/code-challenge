package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q47
 * @Description: https://leetcode-cn.com/problems/permutations-ii/
 * @author: libo
 * @date: 2020/9/18 9:50
 * @Version: 1.0
 */
@Slf4j
public class Q47 {
    public static void main(String[] args) {
        System.out.println(new Q47().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> dis = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path, dis, new int[nums.length]);
        return new ArrayList<>(dis);
    }

    private void dfs(int[] nums, int begin, Deque<Integer> path, Set<List<Integer>> dis, int[] pos) {
        log.info(begin + " " + nums.length);
        if (begin >= nums.length) {
            dis.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (pos[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            pos[i] = 1;
            dfs(nums, begin + 1, path, dis, pos);
            path.removeLast();
            pos[i] = 0;
        }
    }
}
