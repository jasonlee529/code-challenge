package cn.lee.leetcode.probolems.g13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title : Q1375
 * @Description: :
 * @author: liboar@yonyou.com 81915
 * @date: 2023/6/14 8:52
 * @Version:1.0
 */
public class Q1375 {
    /**
     * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
     * <p>
     * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
     * <p>
     * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。
     * <p>
     * 返回二进制字符串在翻转过程中 前缀一致 的次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：flips = [3,2,4,1,5]
     * 输出：2
     * 解释：二进制字符串最开始是 "00000" 。
     * 执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
     * 执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
     * 执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
     * 执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
     * 执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
     * 在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
     * 示例 2：
     * <p>
     * 输入：flips = [4,1,2,3]
     * 输出：1
     * 解释：二进制字符串最开始是 "0000" 。
     * 执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
     * 执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
     * 执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
     * 执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
     * 在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numTimesAllBlue(int[] flips) {
        int cnt = 0;
        List<String> bits = new ArrayList<>();
        for (int i = 1; i <= flips.length; i++) {
            bits.add(String.valueOf(i));
        }
        for (int i = 0; i < flips.length; i++) {
            String index = String.valueOf(flips[i]);
            if (bits.indexOf(index) == 0 ) {
                cnt++;
            }
            bits.remove(index);
            System.out.println(flips.length-flips[i]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q1375 q = new Q1375();
        System.out.println(q.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(q.numTimesAllBlue(new int[]{4, 1, 2, 3}));
    }
}
