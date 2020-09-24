package cn.lee.leetcode.probolems.g5;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Q501
 * @Description: https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @author: libo
 * @date: 2020/9/24 10:02
 * @Version: 1.0
 */
@Slf4j
public class Q501 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> keys = new HashMap<>();
        bst(root, keys);
        int m = 0;
        for (int i : keys.values()) {
            m = m > i ? m : i;
        }
        List<Integer> res = new ArrayList<>();
        for (int k : keys.keySet()) {
            if (keys.get(k) == m) {
                res.add(k);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void bst(TreeNode root, Map<Integer, Integer> keys) {
        if (root == null) {
            return;
        }
        keys.put(root.val, keys.getOrDefault(root.val, 0) + 1);
        bst(root.left, keys);
        bst(root.right, keys);
    }

    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode2(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
