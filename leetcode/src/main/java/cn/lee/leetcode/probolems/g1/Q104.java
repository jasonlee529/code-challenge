package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q104
 * @Description: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author: libo
 * @date: 2020/9/9 16:21
 * @Version: 1.0
 */
@Slf4j
public class Q104 {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> path = new LinkedList<>();
        List<Integer> maxs = new ArrayList<>();
        dfs(root, path, maxs);
        if(maxs.size()==0){
            return 0;
        }
        Collections.sort(maxs);
        return maxs.get(maxs.size()-1);
    }

    private void dfs(TreeNode root, Deque<TreeNode> path, List<Integer> maxs) {
        if (root == null) {
            maxs.add(path.size());
            return;
        } else {

            path.add(root.left);
            dfs(root.left, path, maxs);
            path.removeLast();

            path.add(root.right);
            dfs(root.right, path, maxs);
            path.removeLast();

        }
    }


}
