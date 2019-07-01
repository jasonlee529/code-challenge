package cn.lee.lintcode.cat;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/ugly-number-ii/description
 */
public class Question4 {

    public int nthUglyNumber(int n) {
        // write your code here
        if (n == 1) {
            return 1;
        }
        Queue<Long> deque = new PriorityQueue<>();
        deque.offer(1L);
        int[] factors = new int[]{2, 3, 5};
        for (int i = 2; i <= n; i++) {
            long num = deque.poll();
            for (int f : factors) {
                long tmp = f * num;
                if (!deque.contains(tmp))
                    deque.offer(tmp);
            }
        }
        return deque.poll().intValue();
    }

    public static void main(String[] args) {
        Question4 question = new Question4();
        System.out.println(question.nthUglyNumber(1));
        System.out.println(question.nthUglyNumber(9));
        System.out.println(question.nthUglyNumber(1));
    }
}
