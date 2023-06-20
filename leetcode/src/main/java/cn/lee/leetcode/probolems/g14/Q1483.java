package cn.lee.leetcode.probolems.g14;

/**
 * @Title : Q1483
 * @Description: :
 * @author: liboar@yonyou.com 81915
 * @date: 2023/6/12 9:29
 * @Version:1.0
 */
public class Q1483 {
    /**
     * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
     * <p>
     * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
     * <p>
     * 实现 TreeAncestor 类：
     * <p>
     * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
     * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
     * <p>
     * 输入：
     * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
     * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
     * <p>
     * 输出：
     * [null,1,0,-1]
     * <p>
     * 解释：
     * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
     * <p>
     * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
     * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
     * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/kth-ancestor-of-a-tree-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class TreeAncestor {

        public TreeAncestor(int n, int[] parent) {

        }

        public int getKthAncestor(int node, int k) {
            return 0;
        }
    }
}
