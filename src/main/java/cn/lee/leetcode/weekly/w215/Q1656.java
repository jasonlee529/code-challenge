package cn.lee.leetcode.weekly.w215;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Q1656
 * @Description: https://leetcode-cn.com/problems/design-an-ordered-stream/
 * @author: libo
 * @date: 2020/11/16 23:19
 * @Version: 1.0
 */
@Slf4j
public class Q1656 {

    @Test
    public void test() {
        OrderedStream q = new OrderedStream(5);
        Assert.assertArrayEquals(new String[]{}, q.insert(3, "ccccc").toArray(new String[0]));
        Assert.assertArrayEquals(new String[]{"aaaaa"}, q.insert(1, "aaaaa").toArray(new String[1]));
        Assert.assertArrayEquals(new String[]{"bbbbb", "ccccc"}, q.insert(2, "bbbbb").toArray(new String[2]));
        Assert.assertArrayEquals(new String[]{}, q.insert(5, "eeeee").toArray(new String[0]));
        Assert.assertArrayEquals(new String[]{"ddddd", "eeeee"}, q.insert(4, "ddddd").toArray(new String[2]));

    }




    class OrderedStream {
        Map<Integer, String> map = null;
        int ptr = 1;
        int size = 0;
        public OrderedStream(int n) {
            map = new HashMap<>(n);
            ptr = 1;
            size = n;
        }

        public List<String> insert(int id, String value) {
            List<String> res = new ArrayList<>();
            map.put(id, value);
            if (map.containsKey(ptr)) {
                res.add(map.get(ptr));
                for (int i = ptr + 1; i <= size; i++) {
                    if (map.containsKey(i)) {
                        res.add(map.get(i));
                    } else {
                        ptr = i;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
