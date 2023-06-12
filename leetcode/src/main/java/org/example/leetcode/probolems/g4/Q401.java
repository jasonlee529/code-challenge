package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Q401
 * @Description: https://leetcode-cn.com/problems/binary-watch/
 * @author: libo
 * @date: 2020/11/17 13:40
 * @Version: 1.0
 */
@Slf4j
public class Q401 {
    @Test
    public void test() {
//        Assert.assertArrayEquals(new String[]{"1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"},
//                readBinaryWatch(1).toArray(new String[10]));
        String[] actual = readBinaryWatch(2).toArray(new String[]{});
        Arrays.sort(actual);
        String[] expect = new String[]{"0:03", "0:05", "0:06",
                "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34",
                "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01",
                "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08",
                "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"};
        Arrays.sort(expect);
        Assert.assertArrayEquals(expect, actual);
    }

    public List<String> readBinaryWatch(int num) {
        int[] times = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(times, num, 0, stack, res);
        Collections.sort(res);
        return res;
    }

    private void dfs(int[] times, int num, int begin, Stack<Integer> stack, List<String> res) {
        if (stack.size() == num) {
            String timeStr = toTimeString(stack);
            if (timeStr == null) {
                return;
            } else {
                res.add(timeStr);
            }
            return;
        }
        for (int i = begin; i < times.length; i++) {
            stack.push(times[i]);
            dfs(times, num, i + 1, stack, res);
            stack.pop();
        }
    }

    private String toTimeString(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        int[] tmp = new int[10];
        for (Integer n : stack) {
            tmp[n] = 1;
        }
        if (toTimes(tmp, 0, 4, true) == null || toTimes(tmp, 4, 10, false) == null) {
            return null;
        }
        sb.append(toTimes(tmp, 0, 4, true)).append(":").append(toTimes(tmp, 4, 10, false));
        return sb.toString();
    }

    private String toTimes(int[] tmp, int start, int end, boolean isHour) {
        int num = 0;
        for (int i = start; i < end; i++) {
            if (tmp[i] == 1) {
                num += Math.pow(2, i - start);
            }
        }
        if (!isHour) {
            if (num < 10) {
                return "0" + num;
            } else if (num > 59) {
                return null;
            } else {
                return "" + num;
            }

        } else {
            if (num > 11) {
                return null;
            }
            return "" + num;
        }
    }
}
