package cn.lee.leetcode.probolems.g16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: G1601
 * @Description: https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/
 * @author: libo
 * @date: 2022/2/28 0028 7:22
 * @Version: 1.0
 */
@Slf4j
public class G1601 {

    public int maximumRequests(int n, int[][] requests) {
        Arrays.sort(requests, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] pos = new int[requests.length];
        Arrays.fill(pos, 0);
        int ans = 0;
        for (int i = 0; i < requests.length; i++) {
            Deque<int[]> deque = new LinkedList<>();
            deque.offer(requests[i]);
            for (int j = i + 1; j < requests.length; j++) {
                if (pos[j] == 1) {
                    continue;
                }
                int[] head = deque.peekFirst();
                int[] last = deque.peekLast();
                int[] cur = requests[j];
                if (head[0] == cur[1]) {
                    pos[j] = 1;
                    deque.push(cur);
                    ans += deque.size();
                    break;
                } else if (last[1] == cur[0]) {
                    pos[j] = 1;
                    deque.push(cur);
                } else {
                    continue;
                }
            }
        }
        return ans;
    }


    @Test
    public void test_1() {
        Assert.assertEquals(5, maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(3, maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(4, maximumRequests(4, new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}));
    }
}