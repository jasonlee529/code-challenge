package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q830
 * @Description: https://leetcode-cn.com/problems/positions-of-large-groups/
 * @author: libo
 * @date: 2021/1/5 9:30
 * @Version: 1.0
 */
@Slf4j
public class Q830 {
    @Test
    public void test1() {
        Assert.assertEquals("[[3, 6]]", largeGroupPositions("abbxxxxzzy").toString());
    }

    @Test
    public void test2() {
        Assert.assertEquals("[]", largeGroupPositions("abc").toString());
    }

    @Test
    public void test3() {
        Assert.assertEquals("[[3, 5], [6, 9], [12, 14]]", largeGroupPositions("abcdddeeeeaabbbcd").toString());
    }

    @Test
    public void test4() {
        Assert.assertEquals("[[0, 2]]", largeGroupPositions("aaa").toString());
    }
    @Test
    public void test5() {
        Assert.assertEquals("[]", largeGroupPositions("aa").toString());
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        Character pre = null;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (pre == null) {
                tmp.add(i);
                pre = c;
            } else if (pre == c) {
                if (tmp.size() > 1) {
                    tmp.remove(1);
                }
                tmp.add(1, i);
            } else {
                pre = c;
                if (i - tmp.get(0) >= 3) {
                    res.add(tmp);
                }
                tmp = new ArrayList<>();
                tmp.add(i);
            }
        }
        if (tmp.size() >= 2 && tmp.get(1) - tmp.get(0) >= 2) {
            res.add(tmp);
        }
        return res;
    }
}
