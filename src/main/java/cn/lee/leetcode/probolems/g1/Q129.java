package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title: Q129
 * @Description: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @author: libo
 * @date: 2020/10/29 9:01
 * @Version: 1.0
 */
@Slf4j
public class Q129 {
    public static void main(String[] args) {
        System.out.println(new Q129().sumNumbers(TreeNodeFactory.build(new Integer[]{4, 9, 0, 5, 1})));
        System.out.println(new Q129().sumNumbers(TreeNodeFactory.build(new Integer[]{1,2,3})));
    }

    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        Integer sum = 0;
        Stack<TreeNode> path = new Stack<>();
        List<List<TreeNode>> res = new ArrayList<>();
        dfs(root, path, res);
        for (List<TreeNode> nodes : res) {
            sum += sum(nodes);
        }
        return sum;
    }

    private void dfs(TreeNode root, Stack<TreeNode> path, List<List<TreeNode>> res) {
        path.add(root);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            dfs(root.left, path, res);
            path.pop();
        }
        if (root.right != null) {
            dfs(root.right, path, res);
            path.pop();
        }
    }

    private int sum(List<TreeNode> path) {
        int tmp = 0;
        for (TreeNode node : path) {
            tmp = tmp * 10 + node.val;
        }
        return tmp;
    }
}
