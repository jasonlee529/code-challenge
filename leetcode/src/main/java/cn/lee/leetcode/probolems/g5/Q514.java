package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q514
 * @Description: https://leetcode-cn.com/problems/freedom-trail/
 * @author: libo
 * @date: 2020/11/11 8:52
 * @Version: 1.0
 */
@Slf4j
public class Q514 {
    @Test
    public void test() {
        Assert.assertEquals(4, findRotateSteps("godding", "gn"));
        Assert.assertEquals(19, findRotateSteps("nyngl", "yyynnnnnnlllggg"));
    }

    public int findRotateSteps(String ring, String key) {
        int steps = 0;
        int cur = 0;
        for (char c : key.toCharArray()) {
            // 正向
            int s1 = -1, c1 = 0;
            for (int i = cur; i < ring.length() * 2; i++) {
                s1++;
                if (c == ring.charAt(i % ring.length())) {
                    c1 = i % ring.length();
                    break;
                }
            }
            // 反向
            int s2 = -1, c2 = 0;
            for (int i = cur; i > -(ring.length() - cur); i--) {
                s2++;
                if (c == ring.charAt((i + ring.length() ) % ring.length())) {
                    c2 = (i + ring.length()) % ring.length();
                    break;
                }
            }
            if (s1 > s2) {
                cur = c2;
                steps += s2;
            } else {
                cur = c1;
                steps += s1;
            }
            steps++;
            System.out.println(c + "  " + cur + "  " + s1 + " " + s2 + " " + steps);
        }
        return steps;
    }
}
