package cn.lee.leetcode.probolems.g5;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Title: Q530
 * @Description: https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * @author: libo
 * @date: 2020/10/12 10:51
 * @Version: 1.0
 */
@Slf4j
public class Q530 {
    public static void main(String[] args) {
        System.out.println(new Q530().getMinimumDifference(TreeNodeFactory.build(new Integer[]{543, 384, 652, null, 445, null, 699})));
    }

    public int getMinimumDifference(TreeNode root) {
        Set<Integer> nums = new TreeSet<>();
        dfs(root, nums);
        int min = Integer.MAX_VALUE;
        List<Integer> arrs = new ArrayList<>(nums);
        for (int i = 0; i < arrs.size(); i++) {
            for (int j = i + 1; j < arrs.size(); j++) {
                min = (arrs.get(j) - arrs.get(i)) > min ? min : (arrs.get(j) - arrs.get(i));
            }
        }
        return min;
    }

    private void dfs(TreeNode root, Set<Integer> nums) {
        if (root == null) {
            return;
        }
        nums.add(root.val);
        dfs(root.left, nums);
        dfs(root.right, nums);
    }
}
