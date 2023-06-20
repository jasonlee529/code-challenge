package cn.lee.leetcode.probolems.g6;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: Q662
 * @Description: https://leetcode.cn/problems/maximum-width-of-binary-tree/?envType=study-plan-v2&envId=bytedance-2023-spring-sprint
 * @author: libo
 * @date: 2023/6/20 0020 23:14
 * @Version: 1.0
 */
@Slf4j
public class Q662 {
    /**
     * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
     * <p>
     * 树的 最大宽度 是所有层中最大的 宽度 。
     * <p>
     * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
     * <p>
     * 题目数据保证答案将会在  32 位 带符号整数范围内。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,3,2,5,3,null,9]
     * 输出：4
     * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,3,2,5,null,null,9,6,null,7]
     * 输出：7
     * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
     * 示例 3：
     * <p>
     * <p>
     * 输入：root = [1,3,2,5]
     * 输出：2
     * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int cnt = 0;
        Queue<TreeNode> pre = new LinkedList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> notNullCur = new LinkedList<>();
        pre.add(root);
        while (pre.size() > 0) {
            TreeNode node = pre.poll();
            if (node == null) {
                cur.offer(null);
                cur.offer(null);
            } else {
                cur.offer(node.left);
                cur.offer(node.right);
                if (node.left != null) {
                    notNullCur.offer(node.left);
                }
                if (node.right != null) {
                    notNullCur.offer(node.right);
                }
            }

            if (pre.size() == 0) {
                if (notNullCur.size() > 0) {
                    pre = cur;
                    cnt = cur.size();
                    cur = new LinkedList<>();
                    notNullCur = new LinkedList<>();
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q662 q = new Q662();
        Assert.assertEquals(4, q.widthOfBinaryTree(TreeNodeFactory.build(new Integer[]{1, 3, 2, 5, 3, null, 9})));
        Assert.assertEquals(7, q.widthOfBinaryTree(TreeNodeFactory.build(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7})));
        Assert.assertEquals(2, q.widthOfBinaryTree(TreeNodeFactory.build(new Integer[]{1, 3, 2, 5})));
    }
}