package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Title: Q452
 * @Description: https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author: libo
 * @date: 2020/11/23 9:18
 * @Version: 1.0
 */
@Slf4j
public class Q452 {
    @Test
    public void test() {
        Assert.assertEquals(2, findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        Assert.assertEquals(2, findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        List<int[]> arrows = new ArrayList<>();
        //arrows.add(points[0]);
        for (int i = 0; i < points.length; i++) {
            int[] bubble = points[i];
            boolean shot = false;
            for (int j = 0; j < arrows.size(); j++) {
                int[] arrow = arrows.get(j);
                if (!(bubble[0] > arrow[1]) && !(bubble[1] < arrow[0])) {
                    shot = true;
                    arrow[0] = Math.max(bubble[0], arrow[0]);
                    arrow[1] = Math.min(bubble[1], arrow[1]);
                }
            }
            if (!shot) {
                arrows.add(bubble);
            }
        }
        return arrows.size();
    }
}
