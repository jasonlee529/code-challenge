package cn.lee.lintcode.cat;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 中文
 * English
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义
 * <p>
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
 * <p>
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
 * <p>
 * 给出n，找到所有的n位十进制水仙花数。
 * <p>
 * 你可以认为n小于8。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入: 1
 * 输出: [0,1,2,3,4,5,6,7,8,9]
 * 样例 2:
 * <p>
 * 输出:  2
 * 输出: []
 * 样例解释: 没有2位数的水仙花数。
 */
public class Question147 {

    public static void main(String[] args) {
        Question147 q147 = new Question147();
        q147.getNarcissisticNumbers(1);
    }

    public List<Integer> getNarcissisticNumbers(int n) {
        List<Integer> result = new ArrayList<>();
        // write your code here
        long start = Math.round(Math.pow(10, n - 1))-1;
        long end = Math.round(Math.pow(10, n ));
        for (long i = start; i < end; i++) {
            int r = 0;
            long t = i;
            while (t != 0) {
                r += Math.pow(t % 10, n);
                t = t / 10;
            }
            if(r == i){
                result.add(new Long(i).intValue());
            }
        }
        for (Integer t : result) {
            System.out.println(t);
        }
        return result;
    }
}
