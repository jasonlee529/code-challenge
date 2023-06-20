package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Q406
 * @Description: https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @author: libo
 * @date: 2020/11/16 9:09
 * @Version: 1.0
 */
@Slf4j
public class Q406 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}},
                reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[][] dest = new int[people.length][2];
        List<int[]> lists = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] tmp = people[i];
            if (tmp[1] == 0) {
                lists.add(tmp);
            } else {
                int cnt = 0;
                int index = 0;
                for (int[] t : lists) {
                    if (tmp[0] <= t[0]) {
                        if (cnt >= tmp[1]) {
                            break;
                        } else {
                            cnt++;
                        }
                    }
                    index++;
                }
                lists.add(index, tmp);
            }
        }
        dest = lists.toArray(dest);
        System.out.println(Arrays.toString(dest));
        return dest;
    }
}
