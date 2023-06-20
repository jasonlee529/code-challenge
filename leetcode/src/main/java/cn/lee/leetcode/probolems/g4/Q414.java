package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Title: Q414
 * @Description: https://leetcode-cn.com/problems/third-maximum-number/
 * @author: libo
 * @date: 2020/11/23 19:29
 * @Version: 1.0
 */
@Slf4j
public class Q414 {
    @Test
    public void test() {
        Assert.assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));
        Assert.assertEquals(-2147483648, thirdMax(new int[]{1, 2, -2147483648}));
    }

    @Test
    public void test2() {
        Set<Integer> sets = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        sets.add(1);
        sets.add(-1);
        sets.add(Integer.MIN_VALUE);
        System.out.println(Arrays.toString(sets.toArray(new Integer[]{})));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, thirdMax(new int[]{-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1}));
    }

    public int thirdMax(int[] nums) {
        List<Integer> list = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        if (list.size() > 2) {
            return list.get(list.size() - 1 - 2);
        } else {
            return list.get(list.size() - 1);
        }
    }

    public int thirdMax3(int[] nums) {
        Set<Integer> sets = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 == o1 ? 0 : o2 > o1 ? 1 : -1;
            }
        });
        for (int n : nums) {
            sets.add(n);
        }
        Iterator<Integer> iterator = sets.iterator();
        int first = iterator.next();
        int index = 1;
        while (iterator.hasNext()) {
            index++;
            if (index == 3) {
                first = iterator.next();
                break;
            }
            iterator.next();
        }
        return first;
    }

    public int thirdMax2(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int thrid = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n == first) {
                continue;
            }
            int t = Math.min(n, first);
            first = Math.max(n, first);
            if (n == second) {
                continue;
            }
            int t2 = Math.min(t, second);
            second = Math.max(second, t);
            if (n == thrid) {
                continue;
            }
            thrid = Math.max(thrid, t2);
        }
        return thrid == Integer.MIN_VALUE ? first : thrid;
    }
}
