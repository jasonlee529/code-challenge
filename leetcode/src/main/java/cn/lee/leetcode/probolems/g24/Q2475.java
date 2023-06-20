package cn.lee.leetcode.probolems.g24;

/**
 * @Title : Q2475
 * @Description: :
 * @author: liboar@yonyou.com 81915
 * @date: 2023/6/13 9:10
 * @Version:1.0
 */
public class Q2475 {
    /**
     * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
     * <p>
     * 0 <= i < j < k < nums.length
     * nums[i]、nums[j] 和 nums[k] 两两不同 。
     * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
     * 返回满足上述条件三元组的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,4,2,4,3]
     * 输出：3
     * 解释：下面列出的三元组均满足题目条件：
     * - (0, 2, 4) 因为 4 != 2 != 3
     * - (1, 2, 4) 因为 4 != 2 != 3
     * - (2, 3, 4) 因为 2 != 4 != 3
     * 共计 3 个三元组，返回 3 。
     * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,1,1,1,1]
     * 输出：0
     * 解释：不存在满足条件的三元组，所以返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-unequal-triplets-in-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int unequalTriplets(int[] nums) {
        int cnt = 0;
        int i = 0, j = i + 1, k = j + 1;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q2475 q= new Q2475();
        System.out.println(q.unequalTriplets(new int[]{4,4,2,4,3}));
        System.out.println(q.unequalTriplets(new int[]{1,1,1,1,1}));
    }
}
