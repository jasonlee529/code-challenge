package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q257
 * @Description: https://leetcode-cn.com/problems/binary-tree-paths/
 * @author: libo
 * @date: 2020/9/4 11:29
 * @Version: 1.0
 */
@Slf4j
public class Q257 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.left.left = new TreeNode(3);
        n1.right = new TreeNode(5);
        Q257 p = new Q257();
        System.out.println(p.binaryTreePaths(n1));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String sb = String.valueOf(root.val);
        List<String> strings = new ArrayList<>();
        dfs(root, sb, strings);
        return strings;
    }

    private void dfs(TreeNode root, String sb, List<String> strings) {
        if (root.left != null) {
            dfs(root.left, sb +"->"+ root.left.val, strings);
        }
        if (root.right != null) {
            dfs(root.right, sb +"->"+ root.right.val, strings);
        }
        if (root.left == null && root.right == null) {
            strings.add(sb.toString());
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
