package cn.lee.newcoder.hw;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Title: HJ24
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 20:40
 * @Version: 1.0
 */
@Slf4j
public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        calculate(heights);
    }

    @Test
    public void test_1() {
        Assert.assertEquals(95, calculate(new int[]{16, 103, 132, 23, 211, 75, 155, 82, 32, 48, 79, 183, 13, 91, 51, 172, 109, 102, 189, 121, 12, 120, 116, 133, 79, 120, 116, 208, 47, 110, 65, 187, 69, 143, 140, 173, 203, 35, 184, 49, 245, 50, 179, 63, 204, 34, 218, 11, 205, 100, 90, 19, 145, 203, 203, 215, 72, 108, 58, 198, 95, 116, 125, 235, 156, 133, 220, 236, 125, 29, 235, 170, 130, 165, 155, 54, 127, 128, 204, 62, 59, 226, 233, 245, 46, 3, 14, 108, 37, 94, 52, 97, 159, 190, 143, 67, 24, 204, 39, 222, 245, 233, 11, 80, 166, 39, 224, 12, 38, 13, 85, 21, 47, 25, 180, 219, 140, 201, 11, 42, 110, 209, 77, 136,}));
    }

    public static int calculate(int[] heights) {
        int max = heights[0];
        List<Integer> pos = new ArrayList<>();
        for (int i = 1; i < heights.length; i++) {
            if (max < heights[i]) {
                max = heights[i];
                pos = new ArrayList<>();
                pos.add(i);
            } else if (max == heights[i]) {
                pos.add(i);
            }
        }
        int res = 0;
        for (int maxPos : pos) {
            int ans = 0;
            for (int i = 0; i < heights.length; i++) {
                if (i < maxPos) {
                    if (heights[i] < heights[i + 1]) {
                        ans++;
                    }
                } else if (i > maxPos) {
                    if (heights[i - 1] > heights[i]) {
                        ans++;
                    }
                } else if (i == maxPos) {
                    ans++;
                }
            }
            res = res > ans ? res : ans;
            System.out.println(ans);
        }
        return res;
    }
}