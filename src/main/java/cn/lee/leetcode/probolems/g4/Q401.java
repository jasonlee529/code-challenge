package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        Assert.assertArrayEquals(new String[]{"1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"},
                readBinaryWatch(1).toArray(new String[10]));
    }

    public List<String> readBinaryWatch(int num) {


        return null;
    }
}
